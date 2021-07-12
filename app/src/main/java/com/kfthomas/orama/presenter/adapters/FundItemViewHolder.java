package com.kfthomas.orama.presenter.adapters;

import android.view.View;

import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import com.kfthomas.orama.R;
import com.kfthomas.orama.data.FundCacheData;
import com.kfthomas.orama.data.FundPartialData;
import com.kfthomas.orama.data.OperabilityData;
import com.kfthomas.orama.data.ProfitabilitiesData;
import com.kfthomas.orama.databinding.ItemFundsBinding;

import java.text.DecimalFormat;
import java.text.Format;

final class FundItemViewHolder extends ViewHolderBase<FundCacheData> {

    private final ItemFundsBinding mBinding;

    private void setFundColor(@ColorRes int colorResource){
        final int color = ContextCompat.getColor(itemView.getContext(), colorResource);

        mBinding.fundColor.setBackgroundColor(color);
    }

    private void setName(CharSequence name){
        mBinding.txtFundName.setText(name);
    }

    private void setIncome(ProfitabilitiesData profitabilities){
        String interval = "12M";
        String percentage = profitabilities.getM12();
        Double profitability = null;

        if(percentage != null){
            profitability = tryParseToDouble(percentage);
        }
        else
        {
            Double month = tryParseToDouble(profitabilities.getMonth());

            if(month != null && month > 0)
                profitability = month;
        }

        if(profitability == null)
            profitability = 0d;

        final Format format = new DecimalFormat("#0.00%");
        percentage = format.format(profitability);

        mBinding.txtFundIncome.setText(getString(R.string.fundItemIncome, percentage, interval));
    }

    private void setInitialApplication(String minimumApplication) {

        final Double value = tryParseToDouble(minimumApplication);

        try {
            final Format format = new DecimalFormat("R$ ###,###,###,##0.00");
            minimumApplication = format.format(value);
        }
        catch (IllegalArgumentException ignore){
            minimumApplication = "R$ 0.00";
        }

        minimumApplication = getString(R.string.fundItemMinimumApplication, minimumApplication);

        mBinding.txtFundMinimumApplication.setText(minimumApplication);
    }

    @ColorRes
    private int getFundColor(boolean isActive){
        return isActive? R.color.activeFundItem : R.color.inactiveFundItem;
    }

    private Double tryParseToDouble(String value){
        if (value == null)
            return null;

        Double result = null;

        try {
            result = Double.parseDouble(value);
        }
        catch (NumberFormatException ignore){}

        return result;
    }

    public void onBind(@NonNull FundCacheData cache){
        final FundPartialData data = cache.getFundPartialData();
        final ProfitabilitiesData profitabilities = data.getProfitabilities();
        final OperabilityData operability = data.getOperability();

        setName(data.getSimpleName());
        setFundColor(getFundColor(data.getIsActive()));
        setIncome(profitabilities);
        setInitialApplication(operability.getMinimumInitialApplicationAmount());
    }

    public FundItemViewHolder(@NonNull View itemView) {
        super(itemView);

        mBinding = ItemFundsBinding.bind(itemView);
    }
}
