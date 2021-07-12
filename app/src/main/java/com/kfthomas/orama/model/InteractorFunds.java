package com.kfthomas.orama.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Consumer;

import com.kfthomas.orama.data.FundCacheData;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public final class InteractorFunds extends InteractorBase {

    @Nullable
    private FundDataDAO getDao(){
        final AppDatabase database = getDatabase();

        if(database != null)
            return database.getFundsDataDAO();

        return null;
    }

    public Disposable loadItem(long id, @NonNull Consumer<FundCacheData> onFinish){
        final FundDataDAO dao = getDao();

        if(dao == null)
            return Disposable.empty();

        return dao.getByIdAsync(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSuccess(onFinish::accept)
                .subscribe();
    }

    public Disposable loadTopFunds(@NonNull Consumer<List<FundCacheData>> onFinish){
        final FundDataDAO dao = getDao();

        if(dao == null){
            onFinish.accept(new ArrayList<>());
            return Disposable.empty();
        }

        return dao.getTopFundsAsync()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSuccess(onFinish::accept)
                .subscribe();
    }

    public Disposable loadCache(int size, @NonNull Consumer<List<FundCacheData>> onFinish){
        final FundDataDAO dao = getDao();

        if(dao == null){
            onFinish.accept(new ArrayList<>());
            return Disposable.empty();
        }

        return dao.getAsync(size)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSuccess(onFinish::accept)
                .subscribe();
    }

}
