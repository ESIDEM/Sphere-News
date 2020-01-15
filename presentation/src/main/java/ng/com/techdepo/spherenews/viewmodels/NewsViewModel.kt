package ng.com.techdepo.spherenews.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ng.com.techdepo.domain.usecases.specific.*
import ng.com.techdepo.spherenews.Event
import ng.com.techdepo.spherenews.EventState
import ng.com.techdepo.spherenews.dto.PresentationArticle
import ng.com.techdepo.spherenews.mapper.ArticleMapper
import javax.inject.Inject

class NewsViewModel @Inject constructor(private val getNewsRemote: GetNewsRemote,
                                        private val getNewsLocal: GetNewsLocal,
                                        private val getUserImputNews: GetUserImputNews
                                        ):ViewModel() {


    val articleM = ArticleMapper()
    var newsList = MutableLiveData<Event<List<PresentationArticle>>>()

    var newsListForBinding = MutableLiveData<List<PresentationArticle>>()

    private val _navigateToSelectedArticle = MutableLiveData<PresentationArticle>()
    val navigateToSelectedArticle: LiveData<PresentationArticle>
        get() = _navigateToSelectedArticle

 fun getNewsLocal(){

    getNewsLocal.execute(null,{news ->

        newsListForBinding.postValue(articleM.mapFromDomain(news))

    },{ error ->


    }
    )

}
    init {
        getNewsLocal()
    }

    fun getNewsRemote(mutableList: MutableList<String>){

        //show progress
        newsList.postValue(Event(eventState = EventState.LOADING))

        getNewsRemote.execute(mutableList,{news ->

            newsList.postValue(Event(EventState.SUCCESS,data = articleM.mapFromDomain(news)))

        },{ error ->

            newsList.postValue(Event(EventState.ERROR,throwable = error))
            Log.d("NewsViewModel",error.message.toString())

        }
            )
    }

    fun getUserImput(mutableList: MutableList<String>){

        //show progress
        newsList.postValue(Event(eventState = EventState.LOADING))

        getUserImputNews.execute(mutableList,{news ->

            newsList.postValue(Event(EventState.SUCCESS,data = articleM.mapFromDomain(news)))

        },{ error ->

            newsList.postValue(Event(EventState.ERROR,throwable = error))
            Log.d("NewsViewModel",error.message.toString())

        }
        )
    }

    fun displayPropertyDetails(article: PresentationArticle) {
        _navigateToSelectedArticle.value = article
    }

    fun displayPropertyDetailsComplete() {
        _navigateToSelectedArticle.value = null
    }
}