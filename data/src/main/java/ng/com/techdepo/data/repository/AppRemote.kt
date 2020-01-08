package ng.com.techdepo.data.repository

import io.reactivex.Flowable
import ng.com.techdepo.dto.Article

interface AppRemote {

    fun getAllNewsRemote(country:String,apiKey:String): Flowable<List<Article>>
}