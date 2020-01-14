package ng.com.techdepo.spherenews.ui


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
import kotlinx.android.synthetic.main.activity_main.*
import ng.com.techdepo.spherenews.EventState

import ng.com.techdepo.spherenews.R
import ng.com.techdepo.spherenews.adapter.NewsAdapter
import ng.com.techdepo.spherenews.adapter.NewsItemDecorator
import ng.com.techdepo.spherenews.databinding.FragmentSportNewsBinding
import ng.com.techdepo.spherenews.hideProgress
import ng.com.techdepo.spherenews.showProgress
import ng.com.techdepo.spherenews.viewmodels.NewsViewModel
import ng.com.techdepo.spherenews.viewmodels.SportNewsViewModel
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class SportNews : Fragment() {

    @Inject
    lateinit var viewModelProvider: ViewModelProvider.Factory
    lateinit var newsViewModel: SportNewsViewModel

    lateinit var binding: FragmentSportNewsBinding
    private lateinit var newsApiConfig: String
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       binding = FragmentSportNewsBinding.inflate(inflater)
        binding.setLifecycleOwner (this )

        newsViewModel = ViewModelProviders.of(this,viewModelProvider)[SportNewsViewModel::class.java]
        binding.viewModel = newsViewModel
        binding.newsRecyclerView.addItemDecoration(
            NewsItemDecorator(
                10,30
            )
        )
        binding.newsRecyclerView.adapter = NewsAdapter(NewsAdapter.OnClickListener {

        })

        activity!!.toolbar_title.text = "Sport News"
        newsApiConfig = resources.getString(R.string.api_key)
        val mutableListSport = mutableListOf("sports","50",newsApiConfig)
        newsViewModel.getSportNewsRemote(mutableListSport)
        newsViewModel.sportNewsList.observe(this, Observer {

            it?.let {
                when (it.eventState) {
                    EventState.LOADING -> binding.sweepToRefresh.showProgress()
                    EventState.SUCCESS -> binding.sweepToRefresh.hideProgress()
                    EventState.ERROR -> binding.sweepToRefresh.hideProgress()
                }
                it.data?.let { feeds ->
                }

                it.throwable?.let {
                    Toast.makeText(activity,it.toString(), Toast.LENGTH_SHORT).show()
                }
            }
        })

        return binding.root
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }
}
