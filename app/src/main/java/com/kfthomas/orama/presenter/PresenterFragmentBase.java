package com.kfthomas.orama.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.kfthomas.orama.BuildConfig;
import com.kfthomas.orama.model.InteractorBase;
import com.kfthomas.orama.view.FragmentBase;
import com.kfthomas.orama.view.IFragmentActivity;

public abstract class PresenterFragmentBase<TInteractor extends InteractorBase> {

    @NonNull
    public final TInteractor interactor;

    @Nullable
    private Fragment mFragment;

    @Nullable
    protected final Fragment getFragment(){
        return mFragment;
    }

    @Nullable
    protected final Context getContext(){
        final Fragment fragment = mFragment;

        if(fragment == null)
            return null;

        return fragment.getContext();
    }

    @Nullable
    protected final FragmentActivity getActivity(){
        final Fragment fragment = mFragment;

        if(fragment == null)
            return null;

        return fragment.getActivity();
    }

    @Nullable
    protected final IFragmentActivity getFragmentActivity(){
        final Activity activity = getActivity();

        if(activity instanceof IFragmentActivity)
            return (IFragmentActivity) activity;

        return null;
    }

    @Nullable
    protected final String getFullUrl(@Nullable String partialUrl){
        if(partialUrl == null || partialUrl.isEmpty())
            return null;

        return BuildConfig.BASE_URL_API + partialUrl;
    }

    protected final boolean tryToast(CharSequence sequence, int duration){
        final Context context = getContext();

        if(context == null)
            return false;

        Toast.makeText(context, sequence, duration).show();

        return true;
    }

    protected final boolean tryToast(@StringRes int strResource, int duration){
        final Context context = getContext();

        if(context == null)
            return false;

        Toast.makeText(context, strResource, duration).show();

        return true;
    }

    protected final boolean tryChangeFragment(Fragment fragment){
        final IFragmentActivity activity = getFragmentActivity();

        if(activity == null)
            return false;

        return activity.changeFragment(fragment);
    }

    @Nullable
    protected final AlertDialog tryAlert(CharSequence message,
                                   @Nullable final DialogInterface.OnClickListener listener){
        final Fragment fragment = getFragment();

        if(fragment instanceof FragmentBase)
            return ((FragmentBase<?, ?>) fragment).tryAlert(message, listener);

        return null;
    }

    @CallSuper
    public void onAttach(@NonNull Context context, @Nullable Bundle args){
        interactor.create(context);
    }

    @CallSuper
    public void onCreate(@NonNull Fragment fragment, @Nullable Bundle savedInstanceState){}

    @CallSuper
    public void onViewCreated(@NonNull Fragment fragment, @Nullable Bundle savedInstanceState){
        mFragment = fragment;
    }

    @CallSuper
    public void onSaveInstanceState(@NonNull Fragment fragment, @NonNull Bundle outState) {}

    @CallSuper
    public void onResume(@NonNull Fragment fragment){}

    @CallSuper
    public void onPause(@NonNull Fragment fragment){}

    @CallSuper
    public void onDestroyView(){
        mFragment = null;
    }

    public void onDetach(){
        interactor.destroy();
    }

    protected PresenterFragmentBase(@NonNull TInteractor interactor){
        this.interactor = interactor;
    }
}
