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
public final class StrategyVideoData {

    @JsonProperty
    @ColumnInfo
    private String description;

    @JsonProperty
    @ColumnInfo
    private String title;

    @JsonProperty
    @ColumnInfo
    private String url;

    @JsonProperty
    @ColumnInfo
    private Object published;

    @JsonProperty
    @ColumnInfo
    private Integer id;

    @JsonProperty("enabled_for_tvorama")
    @ColumnInfo(name = "enabled_for_tvorama")
    private Boolean enabledForTvorama;

    @JsonProperty("youtube_id")
    @ColumnInfo(name = "youtube_id")
    private String youtubeId;

    @JsonProperty
    @ColumnInfo
    private Object thumbnail;

    @JsonIgnore
    @Ignore
    private final Map<String, Object> additionalProperties = new HashMap<>();

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Object getPublished() {
        return published;
    }

    public void setPublished(Object published) {
        this.published = published;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getEnabledForTvorama() {
        return enabledForTvorama;
    }

    public void setEnabledForTvorama(Boolean enabledForTvorama) {
        this.enabledForTvorama = enabledForTvorama;
    }

    public String getYoutubeId() {
        return youtubeId;
    }

    public void setYoutubeId(String youtubeId) {
        this.youtubeId = youtubeId;
    }

    public Object getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Object thumbnail) {
        this.thumbnail = thumbnail;
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