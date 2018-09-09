package com.quicksilver.moviesapp.repositories;

import com.quicksilver.moviesapp.http.HttpRequester;
import com.quicksilver.moviesapp.parsers.base.JsonParser;
import com.quicksilver.moviesapp.repositories.base.Repository;

import java.io.IOException;
import java.util.List;

public class HttpRepository<T> implements Repository<T> {
    private HttpRequester mHttpRequester;
    private JsonParser<T> mJsonParser;
    private String mServerUrl;

    public HttpRepository(HttpRequester httpRequester, JsonParser<T> jsonParser, String serverUrl) {
        this.mHttpRequester = httpRequester;
        this.mJsonParser = jsonParser;
        this.mServerUrl = serverUrl;
    }

    @Override
    public List<T> getAll() throws IOException {
        String json = mHttpRequester.get(mServerUrl);

        return mJsonParser.fromJsonArray(json);
    }

    @Override
    public T getById(int id) throws IOException {
        String url = mServerUrl + "/" + id;
        String json = mHttpRequester.get(url);

        return mJsonParser.fromJson(json);
    }

    @Override
    public T add(T item) throws IOException {
        String url = mServerUrl + "/new";
        String requestBody = mJsonParser.toJson(item);
        String responseBody = mHttpRequester.post(url, requestBody);

        return mJsonParser.fromJson(responseBody);
    }

    @Override
    public T update(int id, T object) throws IOException {
        String url = mServerUrl + "/update/" + id;
        String requestBody = mJsonParser.toJson(object);
        String responseBody = mHttpRequester.put(url, requestBody);

        return mJsonParser.fromJson(responseBody);
    }
}
