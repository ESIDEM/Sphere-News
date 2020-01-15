package ng.com.techdepo.spherenews.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ng.com.techdepo.domain.usecases.specific.GetSportNewsLocal
import ng.com.techdepo.domain.usecases.specific.GetSportNewsRemote
import ng.com.techdepo.spherenews.Event
import ng.com.techdepo.spherenews.EventState
import ng.com.techdepo.spherenews.dto.PresentationArticle
import ng.com.techdepo.spherenews.mapper.ArticleMapper
import javax.inject.Inject

class SportNewsViewModel @Inject constructor(private val getSportNewsRemote: GetSportNewsRemote,
                                             private val getSportNewsLocal: GetSportNewsLocal
):ViewModel() {

    val articleM = ArticleMapper()
    var sportNewsListForBinding = MutableLiveData<List<PresentationArticle>>()
    var sportNewsList = MutableLiveData<Event<List<PresentationArticle>>>()

    fun getSportNewsLocal(){

        getSportNewsLocal.execute(null,{news ->

            sportNewsListForBinding.postValue(articleM.mapFromDomain(news))

        },{ error ->


        }
        )

    }

    init {
        getSportNewsLocal()
    }

    fun getSportNewsRemote(mutableList: MutableList<String>){

        //show progress
        sportNewsList.postValue(Event(eventState = EventState.LOADING))

        getSportNewsRemote.execute(mutableList,{news ->

            sportNewsList.postValue(Event(EventState.SUCCESS,data = articleM.mapFromDomain(news)))

        },{ error ->

            sportNewsList.postValue(Event(EventState.ERROR,throwable = error))
            Log.d("NewsViewModel",error.message.toString())

        }
        )
    }

}