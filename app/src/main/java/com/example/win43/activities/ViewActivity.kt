package com.example.win43.activities

import android.os.Bundle
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.viewinterop.AndroidView
import com.onesignal.OneSignal
import com.onesignal.debug.LogLevel

class ViewActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OneSignal.Debug.logLevel = LogLevel.VERBOSE
            OneSignal.initWithContext(this, "714b9f14-381d-4fc4-a93c-28d480557381")
            val url = "https://www.youtube.com/"
            AndroidView(factory = {
                WebView(it).apply {
                    layoutParams = ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                    )
                    webViewClient = WebViewClient()
                    loadUrl(url)
                }
            }, update = {
                it.loadUrl(url)
            })
        }
    }
}
