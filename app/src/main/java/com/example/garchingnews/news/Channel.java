package com.example.garchingnews.news;

import com.example.garchingnews.news.NewsItem;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(strict = false)
public class Channel {

    @Element
    String title;

    @ElementList(inline = true)
    List<NewsItem> newsList;


}
