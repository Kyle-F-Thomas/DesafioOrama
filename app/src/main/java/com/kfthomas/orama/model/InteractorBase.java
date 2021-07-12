package com.kfthomas.orama.model;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.Room;

public abstract class InteractorBase {

    @Nullable
    private static AppDatabase database;

    @Nullable
    protected final AppDatabase getDatabase(){
        return database;
    }

    public final void create(@NonNull Context context){
        if(database == null)
            database = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, "app_database").build();

        onCreate(context);
    }

    public final void destroy(){
        onDestroy();
    }

    protected void onCreate(@NonNull Context context){}

    protected void onDestroy(){}
}
