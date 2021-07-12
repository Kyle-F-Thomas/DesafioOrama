package com.kfthomas.orama.view;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBinding;

import com.kfthomas.orama.presenter.PresenterFragmentBase;

public abstract class FragmentBase<TBinding extends ViewBinding, TPresenter
        extends PresenterFragmentBase<?>>
        extends Fragment {

    @Nullable
    private TBinding mBinding;

    protected final TPresenter presenter;

    @Nullable
    public final TBinding getBinding(){
        return mBinding;
    }

    @Nullable
    protected final ActionBar getSupportActionBar(){
        final Activity activity = getActivity();

        if(activity instanceof AppCompatActivity){
            return ((AppCompatActivity) activity).getSupportActionBar();
        }

        return null;
    }

    @Nullable
    protected final android.app.ActionBar getActionBar()
    {
        final Activity activity = getActivity();

        return activity != null? activity.getActionBar() : null;
    }

    protected final boolean setActionBarTitle(String title){
        final ActionBar supportActionBar = getSupportActionBar();

        if(supportActionBar != null){
            supportActionBar.setTitle(title);
            return true;
        }

        final android.app.ActionBar actionBar = getActionBar();

        if(actionBar != null) {
            actionBar.setTitle(title);
            return true;
        }

        return false;
    }

    @SuppressWarnings("UnusedReturnValue")
    protected final boolean setActionBarTitle(@StringRes int title){
        return setActionBarTitle(getString(title));
    }

    protected final boolean setActionBarVisibilty(boolean visible){
        final ActionBar supportActionBar = getSupportActionBar();

        if(supportActionBar != null){
            if(visible)
                supportActionBar.show();
            else
                supportActionBar.hide();

            return true;
        }

        final android.app.ActionBar actionBar = getActionBar();

        if(actionBar != null) {
            if(visible)
                actionBar.show();
            else
                actionBar.hide();

            return true;
        }

        return false;
    }
    public final AlertDialog tryAlert(CharSequence message,
                                      @Nullable final DialogInterface.OnClickListener listener){
        final Context context = getContext();

        if(context == null)
            return null;

        return new AlertDialog.Builder(context)
                .setMessage(message)
                .setPositiveButton(android.R.string.ok, listener)
                .show();
    }

    public final AlertDialog tryAlert(CharSequence message,
                                      @Nullable final DialogInterface.OnClickListener onAccepted,
                                      @Nullable final DialogInterface.OnClickListener onRefused){
        final Context context = getContext();

        if(context == null)
            return null;

        return new AlertDialog.Builder(context)
                .setMessage(message)
                .setPositiveButton(android.R.string.yes, onAccepted)
                .setNegativeButton(android.R.string.no, onRefused)
                .show();
    }

    public final boolean tryRunOnUiThread(Runnable runnable){
        final Activity activity = getActivity();

        if(activity != null){
            activity.runOnUiThread(runnable);
            return true;
        }

        if(Looper.getMainLooper().getThread() == Thread.currentThread())
        {
            runnable.run();
            return true;
        }

        return false;
    }

    protected final boolean shouldShowRequestPermissionRationale(@NonNull String... permissions){
        for (String permission : permissions)
            if(!shouldShowRequestPermissionRationale(permission))
                return false;

        return true;
    }

    protected final boolean checkIfHasPermission(@NonNull String permission) {
        final Context context = getContext();

        if(context == null)
            return false;

        return Build.VERSION.SDK_INT < Build.VERSION_CODES.M || ContextCompat
                .checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED;
    }

    protected final boolean checkIfHasPermission(@NonNull String... permissions){
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M)
            return true;

        final Context context = getContext();

        if(context == null)
            return false;

        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(context, permission)
                    == PackageManager.PERMISSION_DENIED)
                return false;
        }

        return true;
    }

    @Override
    @CallSuper
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        presenter.onAttach(context, getArguments());
    }

    @Override
    @CallSuper
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter.onCreate(this, savedInstanceState);
    }

    @Override
    @CallSuper
    public final View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        mBinding = onCreateViewBinding(inflater, container, savedInstanceState);

        return mBinding.getRoot();
    }

    @Override
    @CallSuper
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        presenter.onSaveInstanceState(this, outState);
    }

    @Override
    @CallSuper
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        presenter.onViewCreated(this, savedInstanceState);
    }

    @NonNull
    public abstract TBinding onCreateViewBinding(@NonNull LayoutInflater inflater,
                                                 @Nullable ViewGroup container,
                                                 @Nullable Bundle savedInstanceState);

    @Override
    @CallSuper
    public void onResume() {
        super.onResume();

        presenter.onResume(this);
    }

    @Override
    @CallSuper
    public void onPause() {
        super.onPause();

        presenter.onPause(this);
    }

    @Override
    @CallSuper
    public void onDestroyView() {
        super.onDestroyView();

        presenter.onDestroyView();
        mBinding = null;
    }

    @Override
    @CallSuper
    public void onDetach() {
        super.onDetach();
    }

    public FragmentBase(TPresenter presenter){
        this.presenter = presenter;
    }
}
