
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
public final class FundSuitabilityProfileData {

    @JsonProperty("score_range_order")
    @ColumnInfo(name = "score_range_order")
    private Integer scoreRangeOrder;

    @JsonProperty
    @ColumnInfo
    private String name;

    @JsonIgnore
    @Ignore
    private final Map<String, Object> additionalProperties = new HashMap<>();

    public Integer getScoreRangeOrder() {
        return scoreRangeOrder;
    }

    public void setScoreRangeOrder(Integer scoreRangeOrder) {
        this.scoreRangeOrder = scoreRangeOrder;
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
