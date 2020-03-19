package ng.com.techdepo.spherenews.ui



import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.activity_main.*
import ng.com.techdepo.dto.Article
import ng.com.techdepo.spherenews.*
import ng.com.techdepo.spherenews.adapter.NewsAdapter
import ng.com.techdepo.spherenews.adapter.NewsItemDecorator
import ng.com.techdepo.spherenews.databinding.FragmentAllNewsBinding
import ng.com.techdepo.spherenews.dto.PresentationArticle
import ng.com.techdepo.spherenews.viewmodels.NewsViewModel
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class AllNews : Fragment(),SwipeRefreshLayout.OnRefreshListener {

    @Inject
    lateinit var viewModelProvider: ViewModelProvider.Factory
    lateinit var newsViewModel: NewsViewModel

    lateinit var binding: FragmentAllNewsBinding
    private lateinit var userKeyWordInput: String

    private lateinit var newsApiConfig: String
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAllNewsBinding.inflate(inflater)
        binding.setLifecycleOwner (this )
        setHasOptionsMenu(true)

        newsViewModel = ViewModelProviders.of(this,viewModelProvider)[NewsViewModel::class.java]
        binding.viewModel = newsViewModel
        binding.newsRecyclerView.addItemDecoration(NewsItemDecorator(
            10,30
        ))
        binding.newsRecyclerView.adapter = NewsAdapter(NewsAdapter.OnClickListener {
                    newsViewModel.displayPropertyDetails(it)
        })

        newsViewModel.navigateToSelectedArticle.observe(this, Observer {
            if( null!=it){

                this.findNavController().navigate(

                    AllNewsDirections.actionShowDetail(it)
                )

                newsViewModel.displayPropertyDetailsComplete()
            }

        })
           activity!!.toolbar_title.text = "Sphere News"
        newsApiConfig = resources.getString(R.string.api_key)

        userKeyWordInput = ""


        newsViewModel.newsList.observe(this, Observer {
            handlePostFeeds(it)
        })
        return binding.root
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }
    private fun handlePostFeeds(it: Event<List<PresentationArticle>>) {
        it?.let {
            when (it.eventState) {
               EventState.LOADING -> binding.sweepToRefresh.showProgress()
                EventState.SUCCESS -> binding.sweepToRefresh.hideProgress()
                EventState.ERROR -> binding.sweepToRefresh.hideProgress()
            }
            it.data?.let { feeds ->
            }

            it.throwable?.let {
                Toast.makeText(activity,it.toString(),Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        checkUserKeywordInput()
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

        inflater.inflate(R.menu.search_menu,menu)
        setUpSearchMenuItem(menu)
        return super.onCreateOptionsMenu(menu,inflater)


    }

    private fun checkUserKeywordInput() {
        if (userKeyWordInput.isEmpty()) {
            getAllNews()
        } else {
            getUserQuery(userKeyWordInput)
        }
    }
    private fun setUpSearchMenuItem(menu: Menu) {

        val searchView: SearchView = ((menu.findItem(R.id.action_search)?.actionView)) as SearchView
        val searchMenuItem: MenuItem = menu.findItem(R.id.action_search)
        searchView.queryHint = "Type a keyword to search..."
        searchView.setOnQueryTextListener(onQueryTextListenerCallback())
        searchMenuItem.icon.setVisible(false, false)
    }

    private fun onQueryTextListenerCallback(): SearchView.OnQueryTextListener {
        return object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(userInput: String?): Boolean {
                return checkQueryText(userInput)
            }

            override fun onQueryTextChange(userInput: String?): Boolean {
                return checkQueryText(userInput)
            }
        }
    }

    private fun checkQueryText(userInput: String?): Boolean {
        if (userInput != null && userInput.length > 1) {
            userKeyWordInput = userInput
            getUserQuery(userInput)
        } else if (userInput != null && userInput == "") {
            userKeyWordInput = ""
            getAllNews()
        }
        return false
    }

    private fun getUserQuery(userKeywordInput: String) {
        binding.sweepToRefresh.showProgress()
        if (userKeywordInput != null && userKeywordInput.isNotEmpty()) {
            val mutableList = mutableListOf(userKeywordInput,"50",newsApiConfig)
                newsViewModel.getUserImput(mutableList)
        } else {
           getAllNews()
        }
    }

    private fun getAllNews() {
        binding.sweepToRefresh.showProgress()
        val mutableList = mutableListOf("NG","50",newsApiConfig)
        newsViewModel.getNewsRemote(mutableList)
    }

    override fun onRefresh() {
        checkUserKeywordInput()
    }
}
