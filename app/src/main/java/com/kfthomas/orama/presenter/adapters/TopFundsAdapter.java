package com.kfthomas.orama.presenter.adapters;

import com.kfthomas.orama.data.FundCacheData;
import com.kfthomas.orama.model.InteractorFunds;

public final class TopFundsAdapter extends FundListAdapter{


    @Override
    public void load() {
        interactor.loadTopFunds(this::onRefreshFinished);
    }

    public TopFundsAdapter(InteractorFunds interactor, int name,
                           RecyclerViewObserver.Click<FundCacheData> onItemClick) {
        super(interactor, name, false, onItemClick);
    }
}
