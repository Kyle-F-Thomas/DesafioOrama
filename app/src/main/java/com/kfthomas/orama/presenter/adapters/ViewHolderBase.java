package com.kfthomas.orama.presenter.adapters;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.recyclerview.widget.RecyclerView;

abstract class ViewHolderBase<TData> extends RecyclerView.ViewHolder {

    protected final String getString(@StringRes int resource, Object... args){
        return itemView.getResources().getString(resource, args);
    }

    abstract void onBind(TData model);

    protected ViewHolderBase(@NonNull View itemView) {
        super(itemView);
    }
}