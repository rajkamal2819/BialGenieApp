package com.Hackathon.bialgenieapp.Actvities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.Hackathon.bialgenieapp.R;

public class ChatBotActivity extends AppCompatActivity {

    WebView myWebView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_bot);
        myWebView = findViewById(R.id.webview1);
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.loadUrl("https://webchat.botframework.com/embed/xs_bot?s=lPTAVKmnZ8c.qdNbZes7RKvZuXrl3ZCeMujZ-7yOY39r14yy2jKnXeM");
        WebSettings websettings = myWebView.getSettings();
        websettings.setJavaScriptEnabled(true);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // Check if the key event was the Back button and if there's history
        if ((keyCode == KeyEvent.KEYCODE_BACK) && myWebView.canGoBack()) {
            myWebView.goBack();
            return true;
        }
        // If it wasn't the Back key or there's no web page history, bubble up to the default
        // system behavior (probably exit the activity)
        return super.onKeyDown(keyCode, event);
    }

}