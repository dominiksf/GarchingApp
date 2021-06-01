package com.example.garchingnews.news;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.garchingnews.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsFragment extends Fragment implements Callback<Feed> {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_news, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Toast.makeText(getContext(), "Nachrichten werden geladen", Toast.LENGTH_SHORT).show();
        initViews(getView());
    }

    SwipeRefreshLayout swipeRefreshLayout;
    RecyclerView recyclerView;
    NewsService newsService = new NewsServiceBuilder().build();
    NewsListAdapter newsListAdapter = new NewsListAdapter();

    public void initViews(View view) {
        swipeRefreshLayout = view.findViewById(R.id.swipe_refresh_layout);
        swipeRefreshLayout.setOnRefreshListener(() -> onRefresh());
        recyclerView = view.findViewById(R.id.my_news_list);

        if (recyclerView == null) {
            Log.e("MAIN", "NULL");
        } else
            Log.e("MAIN", "NON-NULL");

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(newsListAdapter);


    }

    public NewsService getNewsService() {
        return newsService;
    }

    public Call<Feed> getNewsCall() {
        return newsService.fetchNews();
    }

    public void onRefresh() {
        Toast.makeText(getContext(), "Nachrichten aktualisiert", Toast.LENGTH_SHORT).show();
        fetchNewsList();
    }

    public void fetchNewsList() {
        Call<Feed> call = getNewsCall();
        call.enqueue(this);
        swipeRefreshLayout.setRefreshing(false);
    }


    @Override
    public void onResponse(Call<Feed> call, Response<Feed> response) {
        if (response.isSuccessful()) {
            Feed feed = response.body();
            onFeedRecieved(feed);

        } else {
            Log.e("MAIN", "onResponse was not successful" + response.message());
            onError();
        }
    }

    @Override
    public void onFailure(Call<Feed> call, Throwable throwable) {
        Log.e("MAIN", throwable.getMessage());
        onError();
    }

    public void onFeedRecieved(Feed feed) {
        Log.d("MAIN", "Feed recieved: " + feed.toString());
        newsListAdapter.setFeed(feed);
    }

    protected void onError() {
        Log.e("MAIN", "Feed request error");
    }

    @Override
    public void onResume() {
        super.onResume();
        fetchNewsList();
    }

}

