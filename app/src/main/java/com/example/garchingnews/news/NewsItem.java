package com.example.garchingnews.news;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "item", strict = false)
public class NewsItem {

    @Element(required = false) String title;
    @Element(required = false) String description;
    @Element String link;
    @Element(name = "pubDate") String publishTime;


}
