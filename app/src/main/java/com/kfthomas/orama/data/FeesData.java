package com.kfthomas.orama.data;

import androidx.room.ColumnInfo;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("unused")
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class FeesData {

    @JsonProperty("maximum_administration_fee")
    @ColumnInfo(name = "maximum_administration_fee")
    private String maximumAdministrationFee;

    @JsonProperty("anticipated_retrieval_fee_value")
    @ColumnInfo(name = "anticipated_retrieval_fee_value")
    private String anticipatedRetrievalFeeValue;

    @JsonProperty("administration_fee")
    @ColumnInfo(name = "administration_fee")
    private String administrationFee;

    @JsonProperty("anticipated_retrieval_fee")
    @ColumnInfo(name = "anticipated_retrieval_fee")
    private String anticipatedRetrievalFee;

    @JsonProperty("performance_fee")
    @ColumnInfo(name = "performance_fee")
    private String performanceFee;

    @JsonProperty("has_anticipated_retrieval")
    @ColumnInfo(name = "has_anticipated_retrieval")
    private Boolean hasAnticipatedRetrieval;

    @JsonIgnore
    @Ignore
    private final Map<String, Object> additionalProperties = new HashMap<>();

    public String getMaximumAdministrationFee() {
        return maximumAdministrationFee;
    }

    public void setMaximumAdministrationFee(String maximumAdministrationFee) {
        this.maximumAdministrationFee = maximumAdministrationFee;
    }

    public String getAnticipatedRetrievalFeeValue() {
        return anticipatedRetrievalFeeValue;
    }

    public void setAnticipatedRetrievalFeeValue(String anticipatedRetrievalFeeValue) {
        this.anticipatedRetrievalFeeValue = anticipatedRetrievalFeeValue;
    }

    public String getAdministrationFee() {
        return administrationFee;
    }

    public void setAdministrationFee(String administrationFee) {
        this.administrationFee = administrationFee;
    }

    public String getAnticipatedRetrievalFee() {
        return anticipatedRetrievalFee;
    }

    public void setAnticipatedRetrievalFee(String anticipatedRetrievalFee) {
        this.anticipatedRetrievalFee = anticipatedRetrievalFee;
    }

    public String getPerformanceFee() {
        return performanceFee;
    }

    public void setPerformanceFee(String performanceFee) {
        this.performanceFee = performanceFee;
    }

    public Boolean getHasAnticipatedRetrieval() {
        return hasAnticipatedRetrieval;
    }

    public void setHasAnticipatedRetrieval(Boolean hasAnticipatedRetrieval) {
        this.hasAnticipatedRetrieval = hasAnticipatedRetrieval;
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
