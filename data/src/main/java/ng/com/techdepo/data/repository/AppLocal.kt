package ng.com.techdepo.data.repository

import io.reactivex.Completable
import io.reactivex.Flowable
import ng.com.techdepo.dto.Article

interface AppLocal {


    fun getLocalNews(): Flowable<List<Article>>
    fun getSportNewsLocal():Flowable<List<Article>>
    fun saveNews(news: List<Article>): Completable
    fun saveSportNews(news: List<Article>): Completable
    fun clearAllNews()
    fun clearSportNews()

}