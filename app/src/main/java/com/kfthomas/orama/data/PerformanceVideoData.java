package com.kfthomas.orama.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
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
@Entity(tableName = "PerformanceVideos")
public final class PerformanceVideoData {

    @JsonIgnore
    @PrimaryKey(autoGenerate = true)
    private Long uid;

    @JsonIgnore
    @ColumnInfo(name = "fund_id")
    private Long fundId;

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
    private String published;

    @JsonProperty
    @ColumnInfo
    private Long id;

    @JsonProperty("enabled_for_tvorama")
    @ColumnInfo(name = "enabled_for_tvorama")
    private Boolean enabledForTvorama;

    @JsonProperty("youtube_id")
    @ColumnInfo(name = "youtube_id")
    private String youtubeId;

    @JsonProperty
    @ColumnInfo
    private String thumbnail;

    @JsonIgnore
    @Ignore
    private final Map<String, Object> additionalProperties = new HashMap<>();

    public Long getUid(){
        return uid;
    }

    public void setUid(Long uid){
        this.uid = uid;
    }

    public Long getFundId(){
        return fundId;
    }

    public void setFundId(Long fundId){
        this.fundId = fundId;
    }

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

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
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
