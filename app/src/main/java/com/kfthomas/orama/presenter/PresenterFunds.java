package com.kfthomas.orama.presenter;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.tabs.TabLayout;
import com.kfthomas.orama.BuildConfig;
import com.kfthomas.orama.R;
import com.kfthomas.orama.data.FundCacheData;
import com.kfthomas.orama.model.InteractorFunds;
import com.kfthomas.orama.presenter.adapters.FundListAdapter;
import com.kfthomas.orama.presenter.adapters.FundsViewPagerAdapter;
import com.kfthomas.orama.presenter.adapters.TopFundsAdapter;
import com.kfthomas.orama.view.FragmentFundDetail;
import com.kfthomas.orama.view.FragmentFunds;
import com.kfthomas.orama.view.IFragmentActivity;

public final class PresenterFunds extends PresenterFragmentBase<InteractorFunds> {

    private final FundListAdapter[] mAdapters;
    private boolean mOfflineMode = false;

    public RecyclerView.Adapter<?> getPagerAdapter(@NonNull Fragment fragment){
        return new FundsViewPagerAdapter(mAdapters, this::onScrollListener);
    }

    @Override
    public void onAttach(@NonNull Context context, @Nullable Bundle args) {
        super.onAttach(context, args);

        if(args != null) {
            mOfflineMode = args.getBoolean(BundleKeys.OFFLINE_MODE, false);
        }
    }

    @Override
    public void onResume(@NonNull Fragment fragment) {
        super.onResume(fragment);

        if(fragment instanceof FragmentFunds)
            ((FragmentFunds) fragment).setOfflineModeAlert(mOfflineMode);
    }

    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position){
        int stringId = android.R.string.unknownName;

        if(position >= 0 && position < mAdapters.length)
        {
            stringId = mAdapters[position].getNameResource();
        }

        tab.setText(stringId);
    }

    public void onScrollListener(@NonNull RecyclerView recyclerView, int dx, int dy){
        final LinearLayoutManager linearLayoutManager =
                (LinearLayoutManager) recyclerView.getLayoutManager();

        final RecyclerView.Adapter<?> listAdapter = recyclerView.getAdapter();

        if(linearLayoutManager == null || !(listAdapter instanceof FundListAdapter))
            return;

        if (!((FundListAdapter) listAdapter).isLoading() &&
                linearLayoutManager.findLastCompletelyVisibleItemPosition() ==
                        listAdapter.getItemCount() - 1)
            ((FundListAdapter) listAdapter).loadMore();
    }

    public boolean onOptionsItemSelected(@NonNull Fragment fragment, @NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.menuAbout){
            return onOptionAboutSelected(fragment, item);
        }

        return false;
    }

    private boolean onOptionAboutSelected(@NonNull Fragment fragment, @NonNull MenuItem item){
        final String message = fragment.getString(R.string.dialogAbout,
                BuildConfig.VERSION_NAME);

        if(fragment instanceof FragmentFunds)
            ((FragmentFunds) fragment).tryAlert(message, null);

        return true;
    }

    private void onFundItemClick(int position, long uniqueId, @NonNull FundCacheData data)
    {
        final IFragmentActivity activity = getFragmentActivity();

        if(activity == null)
            return;

        final FragmentFundDetail detail = new FragmentFundDetail();
        final Bundle args = new Bundle();

        args.putLong(BundleKeys.FUND_UNIQUE_ID, uniqueId);
        detail.setArguments(args);

        activity.changeFragment(detail);
    }

    public PresenterFunds(){
        super(new InteractorFunds());

        mAdapters = new FundListAdapter[]{
                new TopFundsAdapter(interactor, R.string.tabTopFunds, this::onFundItemClick),
                new FundListAdapter(interactor, R.string.tabFundsList, true,
                        this::onFundItemClick)
        };

        for(FundListAdapter adapter : mAdapters){
            adapter.load();
        }
    }
}
