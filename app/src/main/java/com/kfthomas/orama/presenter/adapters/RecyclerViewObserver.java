package com.kfthomas.orama.presenter.adapters;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public interface RecyclerViewObserver {

    interface Click<TModel> {
        void onItemClick ( int position, long uniqueId, @NonNull TModel data);
    }

    interface Gesture{
        void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy);
    }

}
