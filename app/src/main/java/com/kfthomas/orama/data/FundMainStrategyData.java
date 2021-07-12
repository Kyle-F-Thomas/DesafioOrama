
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
public final class FundMainStrategyData {

    @JsonProperty
    @ColumnInfo
    private String explanation;

    @JsonProperty("fund_macro_strategy")
    @ColumnInfo(name = "fund_macro_strategy")
    private Integer fundMacroStrategy;

    @JsonProperty
    @ColumnInfo
    private Long id;

    @JsonProperty
    @ColumnInfo
    private String name;

    @JsonIgnore
    @Ignore
    private final Map<String, Object> additionalProperties = new HashMap<>();

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public Integer getFundMacroStrategy() {
        return fundMacroStrategy;
    }

    public void setFundMacroStrategy(Integer fundMacroStrategy) {
        this.fundMacroStrategy = fundMacroStrategy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
