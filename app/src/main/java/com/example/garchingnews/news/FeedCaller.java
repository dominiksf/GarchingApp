package com.example.garchingnews.news;

import android.util.Log;

import com.example.garchingnews.news.Feed;
import com.example.garchingnews.news.NewsListAdapter;
import com.example.garchingnews.news.NewsService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FeedCaller implements Callback<Feed> {

    NewsListAdapter newsListAdapter = new NewsListAdapter();
    NewsService newsService;

    protected Call<Feed> getNewsCall() {
        return newsService.fetchNews();
    }

    protected void fetchNewsList() {
        Call<Feed> call = getNewsCall();
        call.enqueue(this);
    }


    @Override
    public void onResponse(Call<Feed> call, Response<Feed> response) {
        if (response.isSuccessful()) {
            Feed feed = response.body();
            onFeedRecieved(feed);

        } else {
            Log.e("NewsListFragment", "onResponse was not successful");
            onError();
        }
    }

    @Override
    public void onFailure(Call<Feed> call, Throwable throwable) {
        Log.e("NewsListFragment", throwable.getMessage());
        onError();
    }

    protected void onFeedRecieved(Feed feed) {
        Log.d("NewsListFragment", "Feed recieved: " + feed.toString());
        newsListAdapter.setFeed(feed);
    }

    protected void onError() {
        Log.e("NewsListFragment", "Feed request error");
    }

}
