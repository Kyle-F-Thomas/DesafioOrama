
package com.kfthomas.orama.data;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Ignore;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("unused")
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class SpecificationData {

    @JsonProperty("fund_main_strategy_name")
    @ColumnInfo(name = "fund_main_strategy_name")
    private String fundMainStrategyName;

    @JsonProperty("fund_suitability_profile")
    @Embedded(prefix = "fund_suitability__profile__")
    private FundSuitabilityProfileData fundSuitabilityProfile;

    @JsonProperty("fund_risk_profile")
    @Embedded(prefix = "fund_risk_profile__")
    private FundRiskProfileData fundRiskProfile;

    @JsonProperty("fund_main_strategy_explanation")
    @ColumnInfo(name = "fund_main_strategy_explanation")
    private String fundMainStrategyExplanation;

    @JsonProperty("fund_type")
    @ColumnInfo(name = "fund_type")
    private String fundType;

    @JsonProperty("fund_class")
    @ColumnInfo(name = "fund_class")
    private String fundClass;

    @JsonProperty("fund_macro_strategy")
    @Embedded(prefix = "fund_macro_strategy__")
    private FundMacroStrategyData fundMacroStrategy;

    @JsonProperty("fund_class_anbima")
    @ColumnInfo(name = "fund_class_anbima")
    private String fundClassAnbima;

    @JsonProperty("fund_main_strategy")
    @Embedded(prefix = "fund_main_strategy__")
    private FundMainStrategyData fundMainStrategy;

    @JsonProperty("is_qualified")
    @ColumnInfo(name = "is_qualified")
    private Boolean isQualified;

    @JsonIgnore
    @Ignore
    private final Map<String, Object> additionalProperties = new HashMap<>();

    public String getFundMainStrategyName() {
        return fundMainStrategyName;
    }

    public void setFundMainStrategyName(String fundMainStrategyName) {
        this.fundMainStrategyName = fundMainStrategyName;
    }

    public FundSuitabilityProfileData getFundSuitabilityProfile() {
        return fundSuitabilityProfile;
    }

    public void setFundSuitabilityProfile(FundSuitabilityProfileData fundSuitabilityProfile) {
        this.fundSuitabilityProfile = fundSuitabilityProfile;
    }

    public FundRiskProfileData getFundRiskProfile() {
        return fundRiskProfile;
    }

    public void setFundRiskProfile(FundRiskProfileData fundRiskProfile) {
        this.fundRiskProfile = fundRiskProfile;
    }

    public String getFundMainStrategyExplanation() {
        return fundMainStrategyExplanation;
    }

    public void setFundMainStrategyExplanation(String fundMainStrategyExplanation) {
        this.fundMainStrategyExplanation = fundMainStrategyExplanation;
    }

    public String getFundType() {
        return fundType;
    }

    public void setFundType(String fundType) {
        this.fundType = fundType;
    }

    public String getFundClass() {
        return fundClass;
    }

    public void setFundClass(String fundClass) {
        this.fundClass = fundClass;
    }

    public FundMacroStrategyData getFundMacroStrategy() {
        return fundMacroStrategy;
    }

    public void setFundMacroStrategy(FundMacroStrategyData fundMacroStrategy) {
        this.fundMacroStrategy = fundMacroStrategy;
    }

    public String getFundClassAnbima() {
        return fundClassAnbima;
    }

    public void setFundClassAnbima(String fundClassAnbima) {
        this.fundClassAnbima = fundClassAnbima;
    }

    public FundMainStrategyData getFundMainStrategy() {
        return fundMainStrategy;
    }

    public void setFundMainStrategy(FundMainStrategyData fundMainStrategy) {
        this.fundMainStrategy = fundMainStrategy;
    }

    public Boolean getIsQualified() {
        return isQualified;
    }

    public void setIsQualified(Boolean isQualified) {
        this.isQualified = isQualified;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
