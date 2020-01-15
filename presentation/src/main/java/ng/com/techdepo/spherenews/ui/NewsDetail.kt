package ng.com.techdepo.spherenews.ui



import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import ng.com.techdepo.spherenews.databinding.FragmentNewsDetailBinding



/**
 * A simple [Fragment] subclass.
 */
class NewsDetail : Fragment() {

        lateinit var webView:WebView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val newsDetailBinding = FragmentNewsDetailBinding.inflate(inflater)
        val article = NewsDetailArgs.fromBundle(arguments!!).selectedArticle
        newsDetailBinding.setLifecycleOwner (this)
        activity!!.toolbar_title.text = article.title
        newsDetailBinding.postProgress.visibility = View.GONE
        webView = newsDetailBinding.webview



        webView.webViewClient = object : WebViewClient(){

            override fun onPageFinished(view: WebView?, url: String?) {
                newsDetailBinding.postProgress.visibility = View.GONE

        }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {

                newsDetailBinding.postProgress.visibility = View.VISIBLE
                super.onPageStarted(view, url, favicon)
            }

            override fun onReceivedError(
                view: WebView?,
                request: WebResourceRequest?,
                error: WebResourceError?
            ) {
                newsDetailBinding.postProgress.visibility = View.GONE
                super.onReceivedError(view, request, error)
            }
        }

       webView.loadUrl(article.url)

        return newsDetailBinding.root

    }


}
