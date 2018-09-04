package com.quicksilver.moviesapp.parsers;

import com.google.gson.Gson;
import com.quicksilver.moviesapp.parsers.base.JsonParser;

import java.util.Arrays;
import java.util.List;

public class GsonJsonParser<T> implements JsonParser<T> {
    private final Class<T> mClazz;
    private final Class<T[]> mClazzArray;
    private final Gson mGson;

    public GsonJsonParser(Class<T> clazz, Class<T[]> clazzArray) {
        this.mClazz = clazz;
        this.mClazzArray = clazzArray;
        this.mGson = new Gson();
    }

    @Override
    public List<T> fromJsonArray(String json) {
        return Arrays.asList(mGson.fromJson(json, mClazzArray));
    }

    @Override
    public T fromJson(String json) {
        return mGson.fromJson(json, mClazz);
    }

    @Override
    public String toJson(T object) {
        return mGson.toJson(object);
    }
}
