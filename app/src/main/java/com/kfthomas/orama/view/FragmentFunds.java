package com.kfthomas.orama.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.tabs.TabLayoutMediator;
import com.kfthomas.orama.R;
import com.kfthomas.orama.databinding.FragmentFundsBinding;
import com.kfthomas.orama.presenter.PresenterFunds;

public final class FragmentFunds extends FragmentBase<FragmentFundsBinding, PresenterFunds> {

    public void setOfflineModeAlert(boolean offlineMode) {
        final FragmentFundsBinding binding = getBinding();

        if(binding == null)
            return;

        binding.offlineAlert.setVisibility(offlineMode? View.VISIBLE : View.GONE);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);
    }

    @Override
    @NonNull
    public FragmentFundsBinding onCreateViewBinding(@NonNull LayoutInflater inflater,
                                                   @Nullable ViewGroup container,
                                                   @Nullable Bundle savedInstanceState){

        return FragmentFundsBinding.inflate(inflater, container, false);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        menu.clear();
        inflater.inflate(R.menu.menu_funds, menu);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final FragmentFundsBinding binding = getBinding();

        if (binding == null)
            return;

        setActionBarVisibilty(true);
        setActionBarTitle(R.string.fundsName);

        binding.fundsViewPager.setAdapter(presenter.getPagerAdapter(this));

        final TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(binding.tabslayout,
                binding.fundsViewPager, presenter::onConfigureTab);

        tabLayoutMediator.attach();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return presenter.onOptionsItemSelected(this, item);
    }

    public FragmentFunds(){
        super(new PresenterFunds());
    }
}

