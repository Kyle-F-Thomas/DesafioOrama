package com.kfthomas.orama.presenter.adapters;

import android.view.View;

import androidx.annotation.NonNull;

public final class SimpleViewHolder extends ViewHolderBase<Object>{

    @Override
    void onBind(Object model) {}

    public SimpleViewHolder(@NonNull View itemView) {
        super(itemView);
    }
}
