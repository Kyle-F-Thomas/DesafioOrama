package com.kfthomas.orama.presenter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Consumer;
import androidx.fragment.app.Fragment;

import com.kfthomas.orama.BuildConfig;
import com.kfthomas.orama.data.FundCacheData;
import com.kfthomas.orama.data.FundManagerData;
import com.kfthomas.orama.model.InteractorFunds;
import com.kfthomas.orama.view.FragmentFundDetail;

public final class PresenterFundDetail extends PresenterFragmentBase<InteractorFunds>
{
    private long uniqueId;

    public String getLogoFullUrl(FundManagerData data){
        if(data == null)
            return null;

        return getFullUrl(data.getLogo());
    }

    public void onLoadFinish(@Nullable FundCacheData cacheData){
        if(cacheData == null)
            return;

        final Fragment fragment = getFragment();

        if(fragment instanceof FragmentFundDetail)
            ((FragmentFundDetail) fragment).setData(cacheData);
    }

    @Override
    public void onAttach(@NonNull Context context, @Nullable Bundle args) {
        super.onAttach(context, args);

        if(args != null){
            uniqueId = args.getLong(BundleKeys.FUND_UNIQUE_ID, -1);

            refreshData();
        }
        else {
            if(context instanceof Activity)
                ((Activity) context).onBackPressed();

            uniqueId = -1;
        }
    }

    private void refreshData(){
        if(uniqueId != -1)
            interactor.loadItem(uniqueId, this::onLoadFinish);
    }

    public PresenterFundDetail() {
        super(new InteractorFunds());
    }
}
