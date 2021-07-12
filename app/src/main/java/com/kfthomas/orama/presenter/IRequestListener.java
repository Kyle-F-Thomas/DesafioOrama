package com.kfthomas.orama.presenter;

import androidx.annotation.StringRes;

import java.util.List;

import io.reactivex.rxjava3.disposables.Disposable;

public interface IRequestListener
{
    interface Sucess<TModel> {
        Disposable onSucess(List<TModel> result);
    }

    interface Error {
        void onError(int statusCode, @StringRes int messageResource, Object... args);
    }

    interface NetworkError{
        void onNetworkError();
    }

    interface Exception {
        void onUnexpectedError(Throwable ex);
    }
}
