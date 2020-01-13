package ng.com.techdepo.data.repository

import io.reactivex.Completable
import io.reactivex.Flowable
import ng.com.techdepo.dto.Article

interface AppDataStore {


    fun getAllNewsRemote(country:String,pageSize:String,apiKey:String): Flowable<List<Article>>
    fun getLocalNews(): Flowable<List<Article>>
    fun getSportNewsRemote(category:String,pageSize:String,apiKey:String):Flowable<List<Article>>
    fun getSportNewsLocal():Flowable<List<Article>>
    fun saveNews(news: List<Article>): Completable
    fun saveSportNews(news: List<Article>): Completable
    fun clearAllNews()
    fun clearSportNews()
}