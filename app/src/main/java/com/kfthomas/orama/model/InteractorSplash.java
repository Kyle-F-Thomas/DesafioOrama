package com.kfthomas.orama.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;

import com.kfthomas.orama.data.FundCacheData;
import com.kfthomas.orama.data.FundJsonData;
import com.kfthomas.orama.data.FundPartialData;
import com.kfthomas.orama.presenter.BackgroundObserver;
import com.kfthomas.orama.presenter.IRequestListener;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public final class InteractorSplash extends InteractorBase{

    private final static AtomicBoolean sRunning = new AtomicBoolean(false);

    private static BackgroundObserver.Progress sProgressObserver;
    private static BackgroundObserver.Finish sFinishObserver;

    public void setProgressObserver(@Nullable BackgroundObserver.Progress progressObserver) {
        sProgressObserver = progressObserver;
    }

    public void setFinishObserver(@Nullable BackgroundObserver.Finish finishObserver){
        sFinishObserver = finishObserver;
    }

    @WorkerThread
    private void saveCache(final FundDataDAO dao, List<FundJsonData> funds){

        final int totalSize = funds.size();

        for (int i = 0; i < totalSize; i++) {
            final FundJsonData data = funds.get(i);

            dao.save(parseToCache(data));
            final BackgroundObserver.Progress observer = sProgressObserver;

            if(observer != null)
                observer.onProgress(i, totalSize);
        }
    }

    public void refreshData(@Nullable IRequestListener.NetworkError onNetworkError,
                            @Nullable IRequestListener.Error onError,
                            @Nullable IRequestListener.Exception onException){
        if(sRunning.get())
            return;

        sRunning.set(true);

        final IFundsAPI api = NetworkAcess.getInstance().create(IFundsAPI.class);

        api.getFundDetailFull().enqueue(
                new NetworkObserverHandler<>(this::onFundDataReceived, onNetworkError,
                        onError, ex -> {
                            sRunning.set(false);

                            if(onException != null)
                                onException.onUnexpectedError(ex);
                        }));
    }

    private Disposable onFundDataReceived(List<FundJsonData> fundJson){
        final AppDatabase database = getDatabase();

        if(database == null)
            return Disposable.empty();

        final FundDataDAO dao = database.getFundsDataDAO();

        return dao.clearTablesAsync()

                .subscribeOn(Schedulers.io())
                .doOnComplete(() -> saveCache(dao, fundJson))
                .doFinally(() -> sRunning.set(false))

                .observeOn(AndroidSchedulers.mainThread())
                .doOnComplete(() -> {
                    final BackgroundObserver.Finish observer = sFinishObserver;

                    if(observer != null)
                        observer.onFinish();
                })

                .subscribe();
    }

    //region parse

    private static FundPartialData parseToPartialData(@NonNull final FundJsonData json){
        final FundPartialData partial = new FundPartialData();

        partial.setId(json.getId());
        partial.setInitialDate(json.getInitialDate());
        partial.setPerformanceAudios(json.getPerformanceAudios());
        partial.setFees(json.getFees());
        partial.setIsSimple(json.getIsSimple());
        partial.setDescriptionSeo(json.getDescriptionSeo());
        partial.setOperability(json.getOperability());
        partial.setFullName(json.getFullName());
        partial.setOpeningDate(json.getOpeningDate());
        partial.setIsClosed(json.getIsClosed());
        partial.setSimpleName(json.getSimpleName());
        partial.setTargetFund(json.getTargetFund());
        partial.setSpecification(json.getSpecification());
        partial.setQuotaDate(json.getQuotaDate());
        partial.setTaxClassification(json.getTaxClassification());
        partial.setCnpj(json.getCnpj());
        partial.setDescription(json.getDescription());
        partial.setIsActive(json.getIsActive());
        partial.setBenchmark(json.getBenchmark());
        partial.setOramaStandard(json.getOramaStandard());
        partial.setSlug(json.getSlug());
        partial.setFundSituation(json.getFundSituation());
        partial.setVolatility12m(json.getVolatility12m());
        partial.setStrategyVideo(json.getStrategyVideo());
        partial.setInsuranceCompanyCode(json.getInsuranceCompanyCode());
        partial.setProfitabilities(json.getProfitabilities());
        partial.setClosedToCaptureExplanation(json.getClosedToCaptureExplanation());
        partial.setClosingDate(json.getClosingDate());
        partial.setShowDetailedReview(json.getShowDetailedReview());
        partial.setNetPatrimony12m(json.getNetPatrimony12m());
        partial.setIsClosedToCapture(json.getIsClosedToCapture());
        partial.setFundManager(json.getFundManager());
        partial.setEsgSeal(json.getEsgSeal());

        return partial;
    }

    private static FundCacheData parseToCache(@Nullable final FundJsonData json) {
        if(json == null)
            return null;

        final FundCacheData cache = new FundCacheData();

        cache.setFundPartialData(parseToPartialData(json));
        cache.setDocuments(json.getDocuments());
        cache.setPerformanceVideos(json.getPerformanceVideos());

        return cache;
    }

    //endregion
}
