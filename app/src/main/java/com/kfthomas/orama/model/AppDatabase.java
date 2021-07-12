package com.kfthomas.orama.model;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.kfthomas.orama.BuildConfig;
import com.kfthomas.orama.data.DocumentData;
import com.kfthomas.orama.data.FundPartialData;
import com.kfthomas.orama.data.PerformanceVideoData;

@Database(entities = {FundPartialData.class, DocumentData.class, PerformanceVideoData.class },
        version = BuildConfig.VERSION_CODE, exportSchema = false)
@TypeConverters(DataConverter.class)
abstract class AppDatabase extends RoomDatabase {

    public abstract FundDataDAO getFundsDataDAO();
}
