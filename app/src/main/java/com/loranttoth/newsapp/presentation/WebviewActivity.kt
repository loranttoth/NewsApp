package com.loranttoth.newsapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import androidx.databinding.DataBindingUtil
import com.loranttoth.newsapp.R
import com.loranttoth.newsapp.databinding.ActivityWebviewBinding

class WebviewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWebviewBinding
    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_webview)

        webView = binding.newsWebView

        val urlStr = intent.getStringExtra(EXTRA_NEWS_LINK)

        webView.loadUrl(urlStr!!)
    }
}