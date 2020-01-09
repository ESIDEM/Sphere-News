package ng.com.techdepo.spherenews


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.AndroidSupportInjection
import io.reactivex.observers.DisposableSingleObserver
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import ng.com.techdepo.domain.usecases.specific.GetNewsRemote
import ng.com.techdepo.dto.Article
import ng.com.techdepo.spherenews.viewmodels.NewsViewModel
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class AllNews : Fragment() {

    @Inject
    lateinit var viewModelProvider: ViewModelProvider.Factory
    lateinit var newsViewModel: NewsViewModel

    private lateinit var newsApiConfig: String
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_all_news, container, false)

        newsViewModel = ViewModelProviders.of(this,viewModelProvider)[NewsViewModel::class.java]

           activity!!.toolbar_title.text = "All News"
        newsApiConfig = resources.getString(R.string.api_key)
        val mutableList = mutableListOf("US",newsApiConfig)
        newsViewModel.getNewsRemote(mutableList)
        newsViewModel.newsList.observe(this, Observer {
            handlePostFeeds(it)
        })

        return root
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }
    private fun handlePostFeeds(it: Event<List<Article>>) {
        it?.let {
            when (it.eventState) {
//                EventState.LOADING -> binding.postProgress.showProgress()
//                EventState.SUCCESS -> binding.postProgress.hideProgress()
//                EventState.ERROR -> binding.postProgress.hideProgress()
            }
            it.data?.let { feeds ->
                if (feeds.isNotEmpty()) {

                    Toast.makeText(activity,feeds.size.toString(),Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(activity,feeds.size.toString(),Toast.LENGTH_SHORT).show()
                }

            }

            it.throwable?.let {
                Toast.makeText(activity,it.toString(),Toast.LENGTH_SHORT).show()
            }
        }
    }

}
