package com.example.garchingnews.news;

import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class NewsServiceBuilder {

    public final static String BASE_URL = "https://www.garching.de";

    public NewsService build() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(SimpleXmlConverterFactory.create()).build();
        return retrofit.create(NewsService.class);
    }
}
