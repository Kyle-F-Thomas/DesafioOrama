
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
@Entity(tableName = "Documents")
public final class DocumentData {

    @JsonIgnore
    @PrimaryKey(autoGenerate = true)
    private Long uid;

    @JsonIgnore
    @ColumnInfo(name = "fund_id")
    private Long fundId;

    @JsonProperty
    @ColumnInfo
    private Integer position;

    @JsonProperty("document_type")
    @ColumnInfo(name = "document_type")
    private String documentType;

    @JsonProperty
    @ColumnInfo
    private String name;

    @JsonProperty("document_url")
    @ColumnInfo(name = "document_url")
    private String documentUrl;

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

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocumentUrl() {
        return documentUrl;
    }

    public void setDocumentUrl(String documentUrl) {
        this.documentUrl = documentUrl;
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
