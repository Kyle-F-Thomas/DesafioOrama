package com.kfthomas.orama.data;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public final class FundCacheData {

    @Embedded
    private FundPartialData fundPartialData = null;

    @JsonProperty
    @Relation(parentColumn = "id", entityColumn = "fund_id")
    private List<DocumentData> documents = null;

    @JsonProperty("performance_videos")
    @Relation(parentColumn = "id", entityColumn = "fund_id")
    private List<PerformanceVideoData> performanceVideos = null;

    public FundPartialData getFundPartialData() {
        return fundPartialData;
    }

    public void setFundPartialData(FundPartialData fundPartialData) {
        this.fundPartialData = fundPartialData;
    }

    public List<DocumentData> getDocuments() {
        return documents;
    }

    public void setDocuments(List<DocumentData> documents) {
        this.documents = documents;
    }

    public List<PerformanceVideoData> getPerformanceVideos() {
        return performanceVideos;
    }

    public void setPerformanceVideos(List<PerformanceVideoData> performanceVideos) {
        this.performanceVideos = performanceVideos;
    }
}
