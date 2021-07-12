
package com.kfthomas.orama.data;

import androidx.room.ColumnInfo;
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
public final class OperabilityData {

    @JsonProperty("has_operations_on_thursdays")
    @ColumnInfo(name = "has_operations_on_thursdays")
    private Boolean hasOperationsOnThursdays;

    @JsonProperty("retrieval_liquidation_days_type")
    @ColumnInfo(name = "retrieval_liquidation_days_type")
    private String retrievalLiquidationDaysType;

    @JsonProperty("application_quotation_days_type")
    @ColumnInfo(name = "application_quotation_days_type")
    private String applicationQuotationDaysType;

    @JsonProperty("retrieval_quotation_days")
    @ColumnInfo(name = "retrieval_quotation_days")
    private Integer retrievalQuotationDays;

    @JsonProperty("anticipated_retrieval_quotation_days_type")
    @ColumnInfo(name = "anticipated_retrieval_quotation_days_type")
    private String anticipatedRetrievalQuotationDaysType;

    @JsonProperty("anticipated_retrieval_quotation_days_str")
    @ColumnInfo(name = "anticipated_retrieval_quotation_days_str")
    private String anticipatedRetrievalQuotationDaysStr;

    @JsonProperty("retrieval_quotation_days_type")
    @ColumnInfo(name = "retrieval_quotation_days_type")
    private String retrievalQuotationDaysType;

    @JsonProperty("anticipated_retrieval_quotation_days")
    @ColumnInfo(name = "anticipated_retrieval_quotation_days")
    private Integer anticipatedRetrievalQuotationDays;

    @JsonProperty("has_operations_on_wednesdays")
    @ColumnInfo(name = "has_operations_on_wednesdays")
    private Boolean hasOperationsOnWednesdays;

    @JsonProperty("minimum_balance_permanence")
    @ColumnInfo(name = "minimum_balance_permanence")
    private String minimumBalancePermanence;

    @JsonProperty("has_operations_on_mondays")
    @ColumnInfo(name = "has_operations_on_mondays")
    private Boolean hasOperationsOnMondays;

    @JsonProperty("has_grace_period")
    @ColumnInfo(name = "has_grace_period")
    private Boolean hasGracePeriod;

    @JsonProperty("application_time_limit")
    @ColumnInfo(name = "application_time_limit")
    private String applicationTimeLimit;

    @JsonProperty("retrieval_time_limit")
    @ColumnInfo(name = "retrieval_time_limit")
    private String retrievalTimeLimit;

    @JsonProperty("has_operations_on_fridays")
    @ColumnInfo(name = "has_operations_on_fridays")
    private Boolean hasOperationsOnFridays;

    @JsonProperty("anticipate_retrieval_liquidation_days")
    @ColumnInfo(name = "anticipate_retrieval_liquidation_days")
    private Integer anticipateRetrievalLiquidationDays;

    @JsonProperty("minimum_initial_application_amount")
    @ColumnInfo(name = "minimum_initial_application_amount")
    private String minimumInitialApplicationAmount;

    @JsonProperty("anticipate_retrieval_liquidation_days_type")
    @ColumnInfo(name = "anticipate_retrieval_liquidation_days_type")
    private String anticipateRetrievalLiquidationDaysType;

    @JsonProperty("retrieval_special_type")
    @ColumnInfo(name = "retrieval_special_type")
    private String retrievalSpecialType;

    @JsonProperty("anticipate_retrieval_liquidation_days_str")
    @ColumnInfo(name = "anticipate_retrieval_liquidation_days_str")
    private String anticipateRetrievalLiquidationDaysStr;

    @JsonProperty("application_quotation_days_str")
    @ColumnInfo(name = "application_quotation_days_str")
    private String applicationQuotationDaysStr;

    @JsonProperty("grace_period_in_days_str")
    @ColumnInfo(name = "grace_period_in_days_str")
    private Object gracePeriodInDaysStr;

    @JsonProperty("retrieval_quotation_days_str")
    @ColumnInfo(name = "retrieval_quotation_days_str")
    private String retrievalQuotationDaysStr;

    @JsonProperty("grace_period_in_days")
    @ColumnInfo(name = "grace_period_in_days")
    private Integer gracePeriodInDays;

    @JsonProperty("retrieval_liquidation_days_str")
    @ColumnInfo(name = "retrieval_liquidation_days_str")
    private String retrievalLiquidationDaysStr;

    @JsonProperty("minimum_subsequent_retrieval_amount")
    @ColumnInfo(name = "minimum_subsequent_retrieval_amount")
    private String minimumSubsequentRetrievalAmount;

    @JsonProperty("retrieval_direct")
    @ColumnInfo(name = "retrieval_direct")
    private Boolean retrievalDirect;

    @JsonProperty("retrieval_liquidation_days")
    @ColumnInfo(name = "retrieval_liquidation_days")
    private Integer retrievalLiquidationDays;

    @JsonProperty("application_quotation_days")
    @ColumnInfo(name = "application_quotation_days")
    private Integer applicationQuotationDays;

    @JsonProperty("max_balance_permanence")
    @ColumnInfo(name = "max_balance_permanence")
    private String maxBalancePermanence;

    @JsonProperty("maximum_initial_application_amount")
    @ColumnInfo(name = "maximum_initial_application_amount")
    private String maximumInitialApplicationAmount;

    @JsonProperty("has_operations_on_tuesdays")
    @ColumnInfo(name = "has_operations_on_tuesdays")
    private Boolean hasOperationsOnTuesdays;

    @JsonProperty("minimum_subsequent_application_amount")
    @ColumnInfo(name = "minimum_subsequent_application_amount")
    private String minimumSubsequentApplicationAmount;

    @JsonIgnore
    @Ignore
    private final Map<String, Object> additionalProperties = new HashMap<>();

    public Boolean getHasOperationsOnThursdays() {
        return hasOperationsOnThursdays;
    }

    public void setHasOperationsOnThursdays(Boolean hasOperationsOnThursdays) {
        this.hasOperationsOnThursdays = hasOperationsOnThursdays;
    }

    public String getRetrievalLiquidationDaysType() {
        return retrievalLiquidationDaysType;
    }

    public void setRetrievalLiquidationDaysType(String retrievalLiquidationDaysType) {
        this.retrievalLiquidationDaysType = retrievalLiquidationDaysType;
    }

    public String getApplicationQuotationDaysType() {
        return applicationQuotationDaysType;
    }

    public void setApplicationQuotationDaysType(String applicationQuotationDaysType) {
        this.applicationQuotationDaysType = applicationQuotationDaysType;
    }

    public Integer getRetrievalQuotationDays() {
        return retrievalQuotationDays;
    }

    public void setRetrievalQuotationDays(Integer retrievalQuotationDays) {
        this.retrievalQuotationDays = retrievalQuotationDays;
    }

    public String getAnticipatedRetrievalQuotationDaysType() {
        return anticipatedRetrievalQuotationDaysType;
    }

    public void setAnticipatedRetrievalQuotationDaysType(String anticipatedRetrievalQuotationDaysType) {
        this.anticipatedRetrievalQuotationDaysType = anticipatedRetrievalQuotationDaysType;
    }

    public String getAnticipatedRetrievalQuotationDaysStr() {
        return anticipatedRetrievalQuotationDaysStr;
    }

    public void setAnticipatedRetrievalQuotationDaysStr(String anticipatedRetrievalQuotationDaysStr) {
        this.anticipatedRetrievalQuotationDaysStr = anticipatedRetrievalQuotationDaysStr;
    }

    public String getRetrievalQuotationDaysType() {
        return retrievalQuotationDaysType;
    }

    public void setRetrievalQuotationDaysType(String retrievalQuotationDaysType) {
        this.retrievalQuotationDaysType = retrievalQuotationDaysType;
    }

    public Integer getAnticipatedRetrievalQuotationDays() {
        return anticipatedRetrievalQuotationDays;
    }

    public void setAnticipatedRetrievalQuotationDays(Integer anticipatedRetrievalQuotationDays) {
        this.anticipatedRetrievalQuotationDays = anticipatedRetrievalQuotationDays;
    }

    public Boolean getHasOperationsOnWednesdays() {
        return hasOperationsOnWednesdays;
    }

    public void setHasOperationsOnWednesdays(Boolean hasOperationsOnWednesdays) {
        this.hasOperationsOnWednesdays = hasOperationsOnWednesdays;
    }

    public String getMinimumBalancePermanence() {
        return minimumBalancePermanence;
    }

    public void setMinimumBalancePermanence(String minimumBalancePermanence) {
        this.minimumBalancePermanence = minimumBalancePermanence;
    }

    public Boolean getHasOperationsOnMondays() {
        return hasOperationsOnMondays;
    }

    public void setHasOperationsOnMondays(Boolean hasOperationsOnMondays) {
        this.hasOperationsOnMondays = hasOperationsOnMondays;
    }

    public Boolean getHasGracePeriod() {
        return hasGracePeriod;
    }

    public void setHasGracePeriod(Boolean hasGracePeriod) {
        this.hasGracePeriod = hasGracePeriod;
    }

    public String getApplicationTimeLimit() {
        return applicationTimeLimit;
    }

    public void setApplicationTimeLimit(String applicationTimeLimit) {
        this.applicationTimeLimit = applicationTimeLimit;
    }

    public String getRetrievalTimeLimit() {
        return retrievalTimeLimit;
    }

    public void setRetrievalTimeLimit(String retrievalTimeLimit) {
        this.retrievalTimeLimit = retrievalTimeLimit;
    }

    public Boolean getHasOperationsOnFridays() {
        return hasOperationsOnFridays;
    }

    public void setHasOperationsOnFridays(Boolean hasOperationsOnFridays) {
        this.hasOperationsOnFridays = hasOperationsOnFridays;
    }

    public Integer getAnticipateRetrievalLiquidationDays() {
        return anticipateRetrievalLiquidationDays;
    }

    public void setAnticipateRetrievalLiquidationDays(Integer anticipateRetrievalLiquidationDays) {
        this.anticipateRetrievalLiquidationDays = anticipateRetrievalLiquidationDays;
    }

    public String getMinimumInitialApplicationAmount() {
        return minimumInitialApplicationAmount;
    }

    public void setMinimumInitialApplicationAmount(String minimumInitialApplicationAmount) {
        this.minimumInitialApplicationAmount = minimumInitialApplicationAmount;
    }

    public String getAnticipateRetrievalLiquidationDaysType() {
        return anticipateRetrievalLiquidationDaysType;
    }

    public void setAnticipateRetrievalLiquidationDaysType(String anticipateRetrievalLiquidationDaysType) {
        this.anticipateRetrievalLiquidationDaysType = anticipateRetrievalLiquidationDaysType;
    }

    public String getRetrievalSpecialType() {
        return retrievalSpecialType;
    }

    public void setRetrievalSpecialType(String retrievalSpecialType) {
        this.retrievalSpecialType = retrievalSpecialType;
    }

    public String getAnticipateRetrievalLiquidationDaysStr() {
        return anticipateRetrievalLiquidationDaysStr;
    }

    public void setAnticipateRetrievalLiquidationDaysStr(String anticipateRetrievalLiquidationDaysStr) {
        this.anticipateRetrievalLiquidationDaysStr = anticipateRetrievalLiquidationDaysStr;
    }

    public String getApplicationQuotationDaysStr() {
        return applicationQuotationDaysStr;
    }

    public void setApplicationQuotationDaysStr(String applicationQuotationDaysStr) {
        this.applicationQuotationDaysStr = applicationQuotationDaysStr;
    }

    public Object getGracePeriodInDaysStr() {
        return gracePeriodInDaysStr;
    }

    public void setGracePeriodInDaysStr(Object gracePeriodInDaysStr) {
        this.gracePeriodInDaysStr = gracePeriodInDaysStr;
    }

    public String getRetrievalQuotationDaysStr() {
        return retrievalQuotationDaysStr;
    }

    public void setRetrievalQuotationDaysStr(String retrievalQuotationDaysStr) {
        this.retrievalQuotationDaysStr = retrievalQuotationDaysStr;
    }

    public Integer getGracePeriodInDays() {
        return gracePeriodInDays;
    }

    public void setGracePeriodInDays(Integer gracePeriodInDays) {
        this.gracePeriodInDays = gracePeriodInDays;
    }

    public String getRetrievalLiquidationDaysStr() {
        return retrievalLiquidationDaysStr;
    }

    public void setRetrievalLiquidationDaysStr(String retrievalLiquidationDaysStr) {
        this.retrievalLiquidationDaysStr = retrievalLiquidationDaysStr;
    }

    public String getMinimumSubsequentRetrievalAmount() {
        return minimumSubsequentRetrievalAmount;
    }

    public void setMinimumSubsequentRetrievalAmount(String minimumSubsequentRetrievalAmount) {
        this.minimumSubsequentRetrievalAmount = minimumSubsequentRetrievalAmount;
    }

    public Boolean getRetrievalDirect() {
        return retrievalDirect;
    }

    public void setRetrievalDirect(Boolean retrievalDirect) {
        this.retrievalDirect = retrievalDirect;
    }

    public Integer getRetrievalLiquidationDays() {
        return retrievalLiquidationDays;
    }

    public void setRetrievalLiquidationDays(Integer retrievalLiquidationDays) {
        this.retrievalLiquidationDays = retrievalLiquidationDays;
    }

    public Integer getApplicationQuotationDays() {
        return applicationQuotationDays;
    }

    public void setApplicationQuotationDays(Integer applicationQuotationDays) {
        this.applicationQuotationDays = applicationQuotationDays;
    }

    public String getMaxBalancePermanence() {
        return maxBalancePermanence;
    }

    public void setMaxBalancePermanence(String maxBalancePermanence) {
        this.maxBalancePermanence = maxBalancePermanence;
    }

    public String getMaximumInitialApplicationAmount() {
        return maximumInitialApplicationAmount;
    }

    public void setMaximumInitialApplicationAmount(String maximumInitialApplicationAmount) {
        this.maximumInitialApplicationAmount = maximumInitialApplicationAmount;
    }

    public Boolean getHasOperationsOnTuesdays() {
        return hasOperationsOnTuesdays;
    }

    public void setHasOperationsOnTuesdays(Boolean hasOperationsOnTuesdays) {
        this.hasOperationsOnTuesdays = hasOperationsOnTuesdays;
    }

    public String getMinimumSubsequentApplicationAmount() {
        return minimumSubsequentApplicationAmount;
    }

    public void setMinimumSubsequentApplicationAmount(String minimumSubsequentApplicationAmount) {
        this.minimumSubsequentApplicationAmount = minimumSubsequentApplicationAmount;
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
