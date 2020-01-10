package ng.com.techdepo.domain.repository


import io.reactivex.Flowable
import ng.com.techdepo.dto.Article

interface NewsRepository {

    fun getAllNewsRemote(country:String,apiKey:String):Flowable<List<Article>>
    fun getLocalNews(): Flowable<List<Article>>

}