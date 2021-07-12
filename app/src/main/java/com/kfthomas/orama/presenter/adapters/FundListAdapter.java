package com.kfthomas.orama.presenter.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.recyclerview.widget.RecyclerView;

import com.kfthomas.orama.R;
import com.kfthomas.orama.data.FundCacheData;
import com.kfthomas.orama.model.InteractorFunds;

import java.util.List;

public class FundListAdapter extends RecyclerView.Adapter<ViewHolderBase<?>>{

    protected final static int
            VIEWHOLER_EMPTY = 10,
            VIEWHOLDER_ITEM = 20,
            VIEWHOLDER_LOAD = 30,
            INTERVAL = 10;

    @StringRes
    private final int mNameResource;
    private final boolean mCanRefresh;
    private final RecyclerViewObserver.Click<FundCacheData> mOnItemClick;

    protected final SafeListWrapper<FundCacheData> items;
    protected final InteractorFunds interactor;

    private boolean mLoading;

    public final boolean isLoading(){
        return mLoading;
    }

    @StringRes
    public int getNameResource() {
        return mNameResource;
    }

    @Override
    public int getItemCount() {
        return items.getViewItemCount();
    }

    @Override
    public int getItemViewType(int position) {
        int size = items.size();

        if(size == 0 && items.isFullLoaded())
            return VIEWHOLER_EMPTY;

        return size == position ? VIEWHOLDER_LOAD : VIEWHOLDER_ITEM;
    }

    @Override
    public long getItemId(int position) {
        final FundCacheData data = items.get(position);

        if(data == null)
            return -1;

        return data.getFundPartialData().getUid();
    }

    protected void onRefreshFinished(List<FundCacheData> cache){
        items.setData(cache, INTERVAL);

        if(!mCanRefresh)
            items.setFullLoaded(true);

        mLoading = false;

        notifyDataSetChanged();
    }

    private void onItemClick(int position){
        if(mOnItemClick == null)
            return;

        final FundCacheData data = items.get(position);

        if(data == null)
            return;

        long uid = data.getFundPartialData().getUid();

        mOnItemClick.onItemClick(position, uid, data);
    }

    @NonNull
    @Override
    public ViewHolderBase<?> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        int viewHolderLayout = R.layout.item_error;

        switch (viewType){
            case VIEWHOLDER_ITEM:
                View itemView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_funds, parent, false);

                return new FundItemViewHolder(itemView);

            case VIEWHOLDER_LOAD:
                viewHolderLayout = R.layout.item_load;
                break;

            case VIEWHOLER_EMPTY:
                viewHolderLayout = R.layout.item_empty;
                break;
        }

        final View simpleView = LayoutInflater.from(parent.getContext())
                .inflate(viewHolderLayout, parent, false);

        return new SimpleViewHolder(simpleView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderBase<?> holder, final int position) {
        if(holder instanceof FundItemViewHolder) {
            holder.itemView.setOnClickListener((view) -> onItemClick(position));

            final FundCacheData data = items.get(position);

            if(data != null)
                ((FundItemViewHolder) holder).onBind(data);
        }
    }

    public void loadMore() {
        if(!mCanRefresh || items.isFullLoaded() || mLoading)
            return;

        final int limit = items.size() + INTERVAL;

        interactor.loadCache(limit, this::onRefreshFinished);
    }

    public void load(){
        interactor.loadCache(INTERVAL, this::onRefreshFinished);
    }

    public FundListAdapter(InteractorFunds interactor, @StringRes int name, boolean canRefresh,
                           RecyclerViewObserver.Click<FundCacheData> onItemClick){
        mCanRefresh = canRefresh;
        mNameResource = name;
        items = new SafeListWrapper<>(canRefresh);
        mOnItemClick = onItemClick;

        this.interactor = interactor;

        setHasStableIds(true);
    }
}
