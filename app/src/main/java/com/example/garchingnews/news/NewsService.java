package com.example.garchingnews.news;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NewsService {

    @GET("/Rathaus+_+Service/Pressemitteilungen.rss")
    public Call<Feed> fetchNews();
}
