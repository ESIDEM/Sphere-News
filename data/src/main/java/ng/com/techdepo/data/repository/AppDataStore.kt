package ng.com.techdepo.data.repository

import io.reactivex.Completable
import io.reactivex.Flowable
import ng.com.techdepo.dto.Article

interface AppDataStore {


    fun getAllNewsRemote(country:String,apiKey:String): Flowable<List<Article>>
    fun getLocalNews(): Flowable<List<Article>>
    fun saveNews(news: List<Article>): Completable
}