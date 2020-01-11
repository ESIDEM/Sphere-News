package ng.com.techdepo.domain.repository


import io.reactivex.Flowable
import ng.com.techdepo.dto.Article

interface NewsRepository {

    fun getAllNewsRemote(country:String,pageSize:String,apiKey:String):Flowable<List<Article>>
    fun getSportNewsRemote(category:String,pageSize:String,apiKey:String):Flowable<List<Article>>
    fun getLocalNews(): Flowable<List<Article>>
    fun getSportNewsLocal():Flowable<List<Article>>

}