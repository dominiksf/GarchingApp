package com.example.garchingnews.news;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.garchingnews.R;
import com.google.android.material.button.MaterialButton;

public class WebBrowserActivity extends AppCompatActivity {

    WebView webView;
    String webLink;

    MaterialButton backButton;
    MaterialButton shareButton;
    MaterialButton openLinkButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_browser);
        getSupportActionBar().hide();
        initViews();
        openWebLink();

    }

    protected void initViews() {
        webView = (WebView) findViewById(R.id.webView);
        backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(view -> onBackPressed());
        shareButton = findViewById(R.id.shareButton);
        shareButton.setOnClickListener(view -> onShareButtonPressed());
        openLinkButton = findViewById(R.id.openLinkButton);
        openLinkButton.setOnClickListener(view -> onOpenLinkButtonPressed());

    }

    protected void onShareButtonPressed() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, webLink);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        Intent shareIntent = Intent.createChooser(intent, "Teilen");
        startActivity(shareIntent);
    }

    protected void onOpenLinkButtonPressed() {
        Uri uri = Uri.parse(webLink);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    protected void openWebLink() {
        Bundle bundle = getIntent().getExtras();
        webLink = (String) bundle.get("URL");
        webView.loadUrl(webLink);
        webView.getSettings().setJavaScriptEnabled(true);
    }


}
