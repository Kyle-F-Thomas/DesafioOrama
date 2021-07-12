package com.kfthomas.orama.presenter.adapters;

import androidx.annotation.Nullable;

import java.util.List;

final class SafeListWrapper<TModel> {

    private final boolean mUseOndemandLoad;

    private int mPreviousSize;
    private boolean mFullLoaded;

    @Nullable
    private List<TModel> mData;

    public void setFullLoaded(boolean value){
        mFullLoaded = value;
    }

    public boolean isFullLoaded(){
        return mFullLoaded;
    }

    public boolean isEmpty(){
        return mData == null || mData.size() <= 0;
    }

    public void setData(List<TModel> data){
        mData = data;
        mFullLoaded = false;
        mPreviousSize = size();
    }

    public void setData(List<TModel> data, int interval){
        int expectedSize = size() + interval;

        this.mData = data;

        mFullLoaded = size() < expectedSize || mPreviousSize == size();
        mPreviousSize = size();
    }

    public int getRealPosition(int position){
        int size = size();

        if(size == 0 || position == size)
            return -1;

        return position;
    }

    @Nullable
    public TModel get(int position){
        if(mData == null)
            return null;

        position = getRealPosition(position);

        if(position >= 0 && position < size())
            return mData.get(position);

        return null;
    }

    public int size(){
        return mData == null? 0 : mData.size();
    }

    public int getViewItemCount(){
        int size = size();

        if(size == 0)
            return 1;

        if(mUseOndemandLoad && !isFullLoaded())
            size++;

        return size;
    }

    public SafeListWrapper(boolean useOnDemandLoad){
        mUseOndemandLoad = useOnDemandLoad;

        setData(null);
    }
}
