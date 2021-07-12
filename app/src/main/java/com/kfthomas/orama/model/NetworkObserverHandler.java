package com.kfthomas.orama.model;

import androidx.annotation.Nullable;

import com.kfthomas.orama.R;
import com.kfthomas.orama.presenter.IRequestListener;

import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

final class NetworkObserverHandler<TModel> implements Callback<List<TModel>> {

    private final IRequestListener.Sucess<TModel> mOnSucess;
    private final IRequestListener.NetworkError mOnNetworkError;
    private final IRequestListener.Error mOnError;
    private final IRequestListener.Exception mOnException;

    @Override
    @EverythingIsNonNull
    public void onResponse(Call<List<TModel>> call, Response<List<TModel>> response) {

        int statusCode = response.code();

        if(response.isSuccessful()) {
            if(mOnSucess != null)
                mOnSucess.onSucess(response.body());
        }
        else if(mOnError != null){
            if(statusCode >= 400 && statusCode <= 599)
                mOnError.onError(statusCode, R.string.errorRequest);
            else
                mOnError.onError(statusCode, R.string.errorException);
        }
    }

    @Override
    @EverythingIsNonNull
    public void onFailure(Call<List<TModel>> call, Throwable t) {
        t.printStackTrace();

        if(t instanceof UnknownHostException || t instanceof SocketTimeoutException)
        {
            if(mOnNetworkError != null)
                mOnNetworkError.onNetworkError();
        }
        else if(mOnException != null) {
            mOnException.onUnexpectedError(t);

            if(mOnError != null)
                mOnError.onError(-1, R.string.errorException);
        }
    }

    public NetworkObserverHandler(
            @Nullable IRequestListener.Sucess<TModel> onSucess,
            @Nullable IRequestListener.NetworkError onNetworkError,
            @Nullable IRequestListener.Error onError,
            @Nullable IRequestListener.Exception onException)
    {
        mOnSucess = onSucess;
        mOnNetworkError = onNetworkError;
        mOnError = onError;
        mOnException = onException;
    }
}
