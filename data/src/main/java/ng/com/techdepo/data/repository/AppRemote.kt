package ng.com.techdepo.data.repository

import io.reactivex.Flowable
import ng.com.techdepo.dto.Article

interface AppRemote {

    fun getAllNewsRemote(country:String,pageSize:String,apiKey:String): Flowable<List<Article>>
    fun getSportNewsRemote(category:String,pageSize:String,apiKey:String):Flowable<List<Article>>
}