package com.kfthomas.orama.presenter;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;

import com.kfthomas.orama.model.InteractorSplash;
import com.kfthomas.orama.view.FragmentFunds;

public final class PresenterSplash extends PresenterFragmentBase<InteractorSplash> {

    private void dismissSplash(boolean offline){
        final Bundle bundle = new Bundle();
        final FragmentFunds fragment = new FragmentFunds();

        bundle.putBoolean(BundleKeys.OFFLINE_MODE, offline);
        fragment.setArguments(bundle);

        tryChangeFragment(fragment);
    }

    public void refreshFunds(){
        interactor.refreshData(this::onNetworkError, this::onError, this::onException);
    }

    private void onError(int statusCode, @StringRes int stringResource, Object... args){
        final Context context = getContext();

        if(context == null)
            return;

        final CharSequence msg = context.getString(stringResource, args);

        tryAlert(msg, this::onAlertDismiss);
    }

    private void onAlertDismiss(DialogInterface dialogInterface, int which) {
        dismissSplash(true);
    }

    private void onNetworkError(){
        dismissSplash(true);
    }

    private void onException(Throwable throwable){

    }

    private void onRefreshFinish() {
        dismissSplash(false);
    }

    @Override
    public void onResume(@NonNull Fragment fragment) {
        super.onResume(fragment);

        if(fragment instanceof BackgroundObserver.Progress)
            interactor.setProgressObserver((BackgroundObserver.Progress) fragment);
    }

    @Override
    public void onPause(@NonNull Fragment fragment) {
        super.onPause(fragment);

        interactor.setProgressObserver(null);
    }

    public PresenterSplash() {
        super(new InteractorSplash());

        interactor.setFinishObserver(this::onRefreshFinish);
    }
}
