package com.kfthomas.orama.view;

import android.Manifest;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.kfthomas.orama.R;
import com.kfthomas.orama.databinding.FragmentSplashBinding;
import com.kfthomas.orama.presenter.BackgroundObserver;
import com.kfthomas.orama.presenter.PresenterSplash;

public final class FragmentSplash extends FragmentBase<FragmentSplashBinding, PresenterSplash>
    implements BackgroundObserver.Progress
{
    //Na teoria INTERNET e ACCESS_NETWORK_STATE são install time,
    // mas preferi precaver possiveis mudanças
    private final ActivityResultLauncher<String> mPermissionRequest =
            registerForActivityResult(new ActivityResultContracts.RequestPermission(),
                    this::checkPermission);

    private void checkPermission(boolean hasPermission){

        if(hasPermission)
            refreshData(true);
        else {
            final Context context = getContext();

            if(context == null)
                return;

            tryAlert(getString(R.string.errorPermission), (d, w) -> {
                System.exit(0);
            });
        }
    }

    private void refreshData(boolean calledByPermissionRequest){
        if(calledByPermissionRequest || checkIfHasPermission(
                Manifest.permission.INTERNET, Manifest.permission.ACCESS_NETWORK_STATE)){
            presenter.refreshFunds();
        }
        else if(shouldShowRequestPermissionRationale(
                Manifest.permission.INTERNET, Manifest.permission.ACCESS_NETWORK_STATE)){
            tryAlert(getString(R.string.warningPermission), (d,w) -> {
                mPermissionRequest.launch(Manifest.permission.INTERNET);
            }, null);
        }
        else
            mPermissionRequest.launch(Manifest.permission.INTERNET);
    }

    @Override
    public void onProgress(int actual, int total) {
        final String messageProgress = getString(R.string.refreshDataProgress, actual, total);

        final FragmentSplashBinding binding = getBinding();

        if (binding != null) {
            tryRunOnUiThread(() -> binding.refreshText.setText(messageProgress));
        }
    }

    @NonNull
    @Override
    public FragmentSplashBinding onCreateViewBinding(@NonNull LayoutInflater inflater,
                                                     @Nullable ViewGroup container,
                                                     @Nullable Bundle savedInstanceState){

        return FragmentSplashBinding.inflate(inflater, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setActionBarVisibilty(false);
    }

    @Override
    public void onResume() {
        super.onResume();

        final FragmentSplashBinding binding = getBinding();

        if(binding != null)
            binding.refreshText.setText(R.string.refreshData);

        refreshData(false);
    }

    public FragmentSplash() {
        super(new PresenterSplash());
    }

}
