package dev.simplesolution.chrome;

import android.view.View;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.Button;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class BingActivity extends AppCompatActivity {
    private WebView webView;
    private Button bntReturn;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      
        setContentView(R.layout.activity_bing);
        webView = findViewById(R.id.bingdict);
        bntReturn = findViewById(R.id.bntReturn);
        setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 处理点击事件
                super.onBackPressed();
            }
        });
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setAllowFileAccess(false); // 安全考虑
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);

        webView.setWebViewClient(new WebViewClient());

        String url = getIntent().getStringExtra("url");        
        webView.loadUrl(url);
        
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
