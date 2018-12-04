package br.com.aulas.webteste3

import android.graphics.Bitmap
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_main.*
import android.view.View


class MainActivity : AppCompatActivity() {

    private val url = "https://www.impacta.edu.br/"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val webview = findViewById<WebView>(R.id.webview) as WebView

        val settings = webview.settings
        settings.javaScriptEnabled = true

        webview.loadUrl(url)

        // Habilita e faz o setup da web view.
        settings.setAppCacheEnabled(true)
        settings.cacheMode = WebSettings.LOAD_DEFAULT
        settings.setAppCachePath(cacheDir.path)


        // Habilita o zoom na web view
        settings.setSupportZoom(true)
        settings.builtInZoomControls = true
        settings.displayZoomControls = true


        // Zoom no text da web view.
        //settings.textZoom = 125


        // Habilita e desabilita imagens na web view
        settings.blockNetworkImage = false
        // Se a  WebView deve carregar as imagens automaticamente.
        settings.loadsImagesAutomatically = true


        // Configura a Webview
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            settings.safeBrowsingEnabled = true  // api 26
        }
        //settings.pluginState = WebSettings.PluginState.ON
        settings.useWideViewPort = true
        settings.loadWithOverviewMode = true
        settings.javaScriptCanOpenWindowsAutomatically = true
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            settings.mediaPlaybackRequiresUserGesture = false
        }

        settings.domStorageEnabled = true
        settings.setSupportMultipleWindows(true)
        settings.loadWithOverviewMode = true
        settings.allowContentAccess = true
        settings.setGeolocationEnabled(true)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            settings.allowUniversalAccessFromFileURLs = true
        }

        settings.allowFileAccess = true

        webview.fitsSystemWindows = true


        webview.setLayerType(View.LAYER_TYPE_HARDWARE, null)

        webview.loadUrl(url)

        // Seta o cliente para a webview
        webview.webViewClient = object : WebViewClient() {
            override fun onPageStarted(view: WebView, url: String, favicon: Bitmap?) {

            }

            override fun onPageFinished(view: WebView, url: String) {

            }
        }
    }

    override fun onBackPressed() {
        if (webview.canGoBack()) {

            webview.goBack()
        }
    }


}
