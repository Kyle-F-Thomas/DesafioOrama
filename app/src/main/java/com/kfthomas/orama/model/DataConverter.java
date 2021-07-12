package com.kfthomas.orama.model;

import androidx.annotation.Nullable;
import androidx.room.TypeConverter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Date;
import java.util.List;

@SuppressWarnings("unused")
public final class DataConverter {

    @TypeConverter
    public Date fromTimestamp(@Nullable Long value){
        return value != null? new Date(value) : null;
    }

    @TypeConverter
    public Long toTimestamp(@Nullable Date value){
        return value != null? value.getTime() : null;
    }

    @TypeConverter
    public List<Object> fromJsonArray(@Nullable String value){
        if(value == null)
            return null;

        final ObjectMapper mapper = new ObjectMapper();

        try {
            return mapper.readValue(value, new TypeReference<List<Object>>(){});
        }
        catch (JsonProcessingException e) {
            e.printStackTrace();

            return null;
        }
    }

    @TypeConverter
    public String toJsonArray(@Nullable List<Object> value){
        if(value == null)
            return null;

        final ObjectMapper mapper = new ObjectMapper();

        try {
            return mapper.writeValueAsString(value);

        } catch (JsonProcessingException e) {
            e.printStackTrace();

            return null;
        }
    }

    @TypeConverter
    public Object fromJson(@Nullable String value){
        if(value == null)
            return null;

        final ObjectMapper mapper = new ObjectMapper();

        try {
            return mapper.readValue(value, Object.class);
        }
        catch (JsonProcessingException e) {
            e.printStackTrace();

            return null;
        }
    }

    @TypeConverter
    public String toJson(@Nullable Object value){
        if(value == null)
            return null;

        final ObjectMapper mapper = new ObjectMapper();

        try {
            return mapper.writeValueAsString(value);
        }
        catch (JsonProcessingException e) {
            e.printStackTrace();

            return null;
        }
    }

}
