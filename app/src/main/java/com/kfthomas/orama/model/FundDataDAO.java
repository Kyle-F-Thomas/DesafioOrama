package com.kfthomas.orama.model;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import com.kfthomas.orama.data.DocumentData;
import com.kfthomas.orama.data.FundCacheData;
import com.kfthomas.orama.data.FundPartialData;
import com.kfthomas.orama.data.PerformanceVideoData;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Single;

@Dao
public abstract class FundDataDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void saveFundPartial(FundPartialData fundPartial);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void saveAllDocuments(List<DocumentData> documens);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void saveAllPerformanceVideos(List<PerformanceVideoData> videos);

    @Transaction
    public void save(FundCacheData fund){
        final FundPartialData partialData = fund.getFundPartialData();
        final Long fundId = partialData.getId();
        final List<DocumentData> documents = fund.getDocuments();
        final List<PerformanceVideoData> videos = fund.getPerformanceVideos();

        for (DocumentData document : documents)
            document.setFundId(fundId);

        for (PerformanceVideoData video : videos)
            video.setFundId(fundId);

        saveFundPartial(partialData);
        saveAllDocuments(documents);
        saveAllPerformanceVideos(videos);
    }

    @Query("DELETE FROM Funds")
    public abstract void clearTableFunds();

    @Query("DELETE FROM Funds")
    public abstract Completable clearTableFundsAsync();

    @Query("DELETE FROM Documents")
    public abstract void clearTableDocuments();

    @Query("DELETE FROM Documents")
    public abstract Completable clearTableDocumentsAsync();

    @Query("DELETE FROM PerformanceVideos")
    public abstract void clearTablePerformanceVideos();

    @Query("DELETE FROM PerformanceVideos")
    public abstract Completable clearTablePerformanceVideosAsync();

    public Completable clearTablesAsync(){
        return Completable.concatArray(
                clearTableFundsAsync(),
                clearTableDocumentsAsync(),
                clearTablePerformanceVideosAsync());
    }

    @Transaction
    public void clearTables(){
        clearTableFunds();
        clearTableDocuments();
        clearTablePerformanceVideos();
    }

    @Transaction
    @Query("SELECT * FROM Funds")
    public abstract Flowable<FundCacheData> getAllAsync();

    @Transaction
    @Query("SELECT * FROM Funds")
    public abstract List<FundCacheData> getAll();

    @Transaction
    @Query("SELECT * FROM Funds ORDER BY initial_date DESC LIMIT :size")
    public abstract List<FundCacheData> get(int size);

    @Transaction
    @Query("SELECT * FROM Funds ORDER BY initial_date DESC LIMIT :size")
    public abstract Single<List<FundCacheData>> getAsync(int size);

    @Transaction
    @Query("SELECT * FROM Funds ORDER BY operability__minimum_initial_application_amount DESC LIMIT 10")
    public abstract List<FundCacheData> getTopFunds();

    @Transaction
    @Query("SELECT * FROM Funds ORDER BY operability__minimum_initial_application_amount DESC LIMIT 10")
    public abstract Single<List<FundCacheData>> getTopFundsAsync();

    @Transaction
    @Query("SELECT * FROM Funds WHERE uid = :uid LIMIT 1")
    public abstract Single<FundCacheData> getByIdAsync(long uid);

    @Transaction
    @Query("SELECT * FROM Funds WHERE uid = :uid LIMIT 1")
    public abstract FundCacheData getById(long uid);


}
