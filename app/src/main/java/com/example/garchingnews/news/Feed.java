package com.example.garchingnews.news;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "rss,", strict = false)
public class Feed {

    @Element
    Channel channel;
}
