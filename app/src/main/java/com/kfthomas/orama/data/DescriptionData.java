
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
public final class DescriptionData {

    @JsonProperty
    @ColumnInfo
    private String objective;

    @JsonProperty("movie_url")
    @ColumnInfo(name = "movie_url")
    private String movieUrl;

    @JsonProperty("target_audience")
    @ColumnInfo(name = "target_audience")
    private String targetAudience;

    @JsonProperty
    @ColumnInfo
    private String strengths;

    @JsonProperty
    @ColumnInfo
    private String strategy;

    @JsonIgnore
    @Ignore
    private final Map<String, Object> additionalProperties = new HashMap<>();

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public String getMovieUrl() {
        return movieUrl;
    }

    public void setMovieUrl(String movieUrl) {
        this.movieUrl = movieUrl;
    }

    public String getTargetAudience() {
        return targetAudience;
    }

    public void setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience;
    }

    public String getStrengths() {
        return strengths;
    }

    public void setStrengths(String strengths) {
        this.strengths = strengths;
    }

    public String getStrategy() {
        return strategy;
    }

    public void setStrategy(String strategy) {
        this.strategy = strategy;
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
