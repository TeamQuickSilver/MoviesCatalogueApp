package com.quicksilver.moviesapp.parsers;

import android.util.Base64;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializer;
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
        this.mGson = initGson();
    }

    private Gson initGson() {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(byte[].class, (JsonSerializer<byte[]>) (src, typeOfSrc, context)
                -> new JsonPrimitive(Base64.encodeToString(src, Base64.NO_WRAP)));
        builder.registerTypeAdapter(byte[].class, (JsonDeserializer<byte[]>) (json, typeOfT, context)
                -> Base64.decode(json.getAsString(), Base64.NO_WRAP));

        return builder.create();
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
