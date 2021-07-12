
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
public final class ProfitabilitiesData {

    @JsonProperty
    @ColumnInfo
    private String m60;

    @JsonProperty
    @ColumnInfo
    private String m48;

    @JsonProperty
    @ColumnInfo
    private String m24;

    @JsonProperty
    @ColumnInfo
    private String m36;

    @JsonProperty
    @ColumnInfo
    private String month;

    @JsonProperty
    @ColumnInfo
    private String m12;

    @JsonProperty
    @ColumnInfo
    private String year;

    @JsonProperty
    @ColumnInfo
    private String day;

    @JsonIgnore
    @Ignore
    private final Map<String, Object> additionalProperties = new HashMap<>();

    public String getM60() {
        return m60;
    }

    public void setM60(String m60) {
        this.m60 = m60;
    }

    public String getM48() {
        return m48;
    }

    public void setM48(String m48) {
        this.m48 = m48;
    }

    public String getM24() {
        return m24;
    }

    public void setM24(String m24) {
        this.m24 = m24;
    }

    public String getM36() {
        return m36;
    }

    public void setM36(String m36) {
        this.m36 = m36;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getM12() {
        return m12;
    }

    public void setM12(String m12) {
        this.m12 = m12;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
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
