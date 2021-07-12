package com.kfthomas.orama.presenter.adapters;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FundPageViewHolder extends ViewHolderBase<RecyclerView.Adapter<?>> {

    @Override
    void onBind(RecyclerView.Adapter<?> adapter) {
        ((RecyclerView) itemView).setAdapter(adapter);
    }

    protected FundPageViewHolder(@NonNull RecyclerView itemView) {
        super(itemView);
    }

}
