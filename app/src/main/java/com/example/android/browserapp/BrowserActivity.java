package com.example.android.browserapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

public class BrowserActivity extends AppCompatActivity {

    Button doneButton;
    Button refreshButton;
    Button backButton;
    Button forwardButton;
    WebView webViewBrowser;
    EditText webBarEditText;
    SharedPreferences mPrefs;
    Argument progressingArg;
    String webUrl;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);


        mPrefs = getPreferences(Context.MODE_PRIVATE);
        loadArgData();

        Intent intent = getIntent();
        progressingArg = (Argument) intent.getSerializableExtra(Keys.PROGRESSING_ARG);

        webBarEditText = (EditText) findViewById(R.id.web_bar_edit_text);
        webBarEditText.setText(progressingArg.getWebUrl());


        //Intialized code for webview
        webViewBrowser = (WebView) findViewById(R.id.web_view_browser);
        webViewBrowser.setWebViewClient(new WebViewClient());
        webViewBrowser.getSettings().setJavaScriptEnabled(true);
        webViewBrowser.loadUrl(progressingArg.getWebUrl());

    }

    //onClick for done to go back to Write Arg Activity
    public void goBackToArgument (View view) {
        String newUrl = webViewBrowser.getOriginalUrl();
        Intent data = new Intent();
        data.putExtra(Keys.RETURN_EVIDENCE, newUrl);
        setResult(RESULT_OK, data);
        finish();
    }

    //back button for browser
    public void goBackAUrl(View view) {
        webViewBrowser.goBack();
        webBarEditText.setText(webViewBrowser.getOriginalUrl());
    }

    //forward button for browser
    public void goForwardAUrl(View view) {
        webViewBrowser.goForward();
        webBarEditText.setText(webViewBrowser.getOriginalUrl());
    }

    public void goBackToGoogle(View view) {
        String googleURL = "http://google.com/";
        webViewBrowser.loadUrl("http://google.com/");
        webBarEditText.setText(googleURL);
    }

    //refresh button for browser
    public void refreshUrl(View view) {
        String url = webBarEditText.getText().toString();
        //must add if/else for if http//: is not there
        webViewBrowser.loadUrl(url);
    }

    public void loadArgData() {
        if (mPrefs.contains("ProgressingArg")) {
            Gson gson = new Gson();
            String json = mPrefs.getString("ProgressingArg", "");
            progressingArg = gson.fromJson(json, Argument.class);
        }
    }


}

//can use capturePicture method possibly