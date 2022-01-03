package com.example.garchingnews.news;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.garchingnews.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class NewsListAdapter extends RecyclerView.Adapter<NewsViewHolder> {

    Feed feed;
    SimpleDateFormat parser = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
    SimpleDateFormat outputFormat = new SimpleDateFormat("dd.MM.yyyy, HH:mm", Locale.GERMAN);

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NewsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.news_card, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        NewsItem newsItem = feed.channel.newsList.get(position);
        holder.titleTextView.setText(newsItem.title);
        holder.descriptionTextView.setText((newsItem.description));
        holder.dateTextView.setText("Stand: " + parseTime(newsItem));

        Log.d("DATE", newsItem.publishTime.toString());
        holder.itemView.setOnClickListener(view -> onNewsClick(view, newsItem));
    }

    public void onNewsClick(View view, NewsItem newsItem) {

        Intent intent = new Intent(view.getContext(), WebBrowserActivity.class);
        intent.putExtra("URL", newsItem.link);
        view.getContext().startActivity(intent);

    }

    @Override
    public int getItemCount() {
        return feed != null ? feed.channel.newsList.size() : 0;
    }

    public void setFeed(Feed feed) {
        this.feed = feed;
        notifyDataSetChanged();
    }

    public String parseTime(NewsItem newsItem) {
        try {
            Date date = parser.parse(newsItem.publishTime);
            Log.e("TIME", date.toString());
            return outputFormat.format(date) + " Uhr";
        } catch (ParseException e) {
            e.printStackTrace();
            return "-";
        }
    }

    public Feed getFeed() {
        return feed;
    }

    public SimpleDateFormat getParser() {
        return parser;
    }

    public SimpleDateFormat getOutputFormat() {
        return outputFormat;
    }
}
