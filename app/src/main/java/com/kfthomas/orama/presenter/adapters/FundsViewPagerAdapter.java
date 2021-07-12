package com.kfthomas.orama.presenter.adapters;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public final class FundsViewPagerAdapter extends RecyclerView.Adapter<FundPageViewHolder>
{
    private final RecyclerView.Adapter<?>[] mAdapters;
    private final RecyclerViewObserver.Gesture mOnScrolledListener;

    private final RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
        }

        @Override
        public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);

            if(mOnScrolledListener != null)
                mOnScrolledListener.onScrolled(recyclerView, dx, dy);
        }
    };

    @Override
    public int getItemCount() {
        return mAdapters.length;
    }

    @NonNull
    @Override
    public FundPageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final Context context = parent.getContext();
        final ViewGroup.LayoutParams recyclerParams = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        final RecyclerView view = new RecyclerView(context);

        view.setLayoutParams(recyclerParams);
        view.setHasFixedSize(true);
        view.setLayoutManager(new LinearLayoutManager(context));
        view.addOnScrollListener(mOnScrollListener);

        return new FundPageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FundPageViewHolder holder, int position) {
        holder.onBind(mAdapters[position]);
    }

    public FundsViewPagerAdapter(RecyclerView.Adapter<?>[] adapters,
                                 RecyclerViewObserver.Gesture onScrolledListener) {
        mAdapters = adapters;
        mOnScrolledListener = onScrolledListener;
    }
}