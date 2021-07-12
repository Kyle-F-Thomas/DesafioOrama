package com.kfthomas.orama;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.kfthomas.orama.databinding.ActivityMainBinding;
import com.kfthomas.orama.presenter.PresenterMain;
import com.kfthomas.orama.view.IFragmentActivity;

public final class ActivityMain extends AppCompatActivity
        implements IFragmentActivity {

    private final PresenterMain mPresenter = new PresenterMain();

    @Nullable
    private ActivityMainBinding mBinding;

    public boolean changeFragment(@NonNull Fragment fragment){
        if(mBinding == null || getSupportFragmentManager().isStateSaved())
            return false;

        int containerId = mBinding.fragmentContainer.getId();

        final FragmentManager fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction()
                .replace(containerId, fragment)
                .addToBackStack(fragment.getTag())
                .commit();

        return true;
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        mPresenter.onActivitySaveInstance(this, outState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(mBinding.getRoot());

        mPresenter.onActivityCreate(this, savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();

        mPresenter.onActivityResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();

        mPresenter.onActivityPause(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mPresenter.onActivityDestroy(this);
    }
}