package com.Hackathon.bialgenieapp.Fragments.Transit;

import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.Hackathon.bialgenieapp.R;

public class Transit_Cab_Ola_Activity extends AppCompatActivity {

    WebView myWebView ;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transit_cab_ola);
        myWebView = findViewById(R.id.webview1);
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.loadUrl(" https://devapi.olacabs.com/oauth2/authorize?response_type=token&client_id=<client_id>\n" +
                "&redirect_uri=<partner's redirect_uri>&scope=profile%20booking");
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

   /* @Override
    public void onBackPressed() {
        if(myWebView.canGoBack()){
            myWebView.canGoBack();
        }else
        {
            super.onBackPressed();
        }

    }*/
}