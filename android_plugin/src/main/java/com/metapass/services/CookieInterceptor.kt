package com.metapass.services

import android.webkit.WebView
import android.webkit.WebViewClient

class CookieInterceptor {

    fun blockThirdPartyCookies(webView: WebView) {
        webView.settings.apply {
            javaScriptEnabled = true
            domStorageEnabled = true
        }

        webView.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                view?.evaluateJavascript(
                    """
                    document.cookie.split(";").forEach(function(cookie) {
                        document.cookie = cookie + ";expires=Thu, 01 Jan 1970 00:00:00 UTC";
                    });
                    """.trimIndent(), null
                )
            }
        }
    }
}
