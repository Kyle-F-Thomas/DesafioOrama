package com.kfthomas.orama.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.kfthomas.orama.data.DescriptionData;
import com.kfthomas.orama.data.FundCacheData;
import com.kfthomas.orama.data.FundPartialData;
import com.kfthomas.orama.databinding.FragmentFundDetailBinding;
import com.kfthomas.orama.presenter.PresenterFundDetail;

public final class FragmentFundDetail
        extends FragmentBase<FragmentFundDetailBinding, PresenterFundDetail> {

    public void setData(@Nullable FundCacheData data){
        final FragmentFundDetailBinding binding = getBinding();
        final Context context = getContext();

        if(data == null || binding == null || context == null)
            return;

        final FundPartialData partialData = data.getFundPartialData();

        if(partialData == null)
            return;

        final DescriptionData description = partialData.getDescription();

        if(description == null)
            return;

        final String logoUrl = presenter.getLogoFullUrl(partialData.getFundManager());

        if(logoUrl != null)
            Glide.with(context)
                    .load(logoUrl)
                    .error(android.R.drawable.ic_delete)
                    .into(binding.logo);

        binding.title.setText(partialData.getFullName());
        binding.objective.setText(description.getObjective());
    }

    @NonNull
    @Override
    public FragmentFundDetailBinding onCreateViewBinding(@NonNull LayoutInflater inflater,
                                                         @Nullable ViewGroup container,
                                                         @Nullable Bundle savedInstanceState) {
        return FragmentFundDetailBinding.inflate(inflater, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setActionBarVisibilty(false);
    }

    public FragmentFundDetail() {
        super(new PresenterFundDetail());
    }
}
