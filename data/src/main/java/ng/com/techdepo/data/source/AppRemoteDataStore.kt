package ng.com.techdepo.data.source

import io.reactivex.Completable
import io.reactivex.Flowable
import ng.com.techdepo.data.repository.AppRemote
import ng.com.techdepo.data.repository.AppDataStore
import ng.com.techdepo.data.repository.AppLocal
import ng.com.techdepo.dto.Article
import javax.inject.Inject

class AppRemoteDataStore @Inject constructor(val remote: AppRemote, val appLocal: AppLocal):AppDataStore {

    override fun getAllNewsRemote(country: String, pageSize: String,apiKey: String): Flowable<List<Article>> {
        return remote.getAllNewsRemote(country,pageSize,apiKey).doOnNext {

            if (it.isEmpty()) {
                appLocal.saveNews(it).subscribe()
            }else{
                appLocal.clearAllNews()
                appLocal.saveNews(it).subscribe()
            }
        }
    }

    override fun getLocalNews(): Flowable<List<Article>> {
        throw UnsupportedOperationException()
    }

    override fun getSportNewsRemote(
        category: String,
        pageSize: String,
        apiKey: String
    ): Flowable<List<Article>> {
       return remote.getSportNewsRemote(category,pageSize,apiKey).doOnNext {
           if (it.isEmpty()){
               appLocal.saveSportNews(it).subscribe()
           }else{

               appLocal.clearSportNews()
               appLocal.saveSportNews(it).subscribe()
           }

       }
    }

    override fun getSportNewsLocal(): Flowable<List<Article>> {
        throw UnsupportedOperationException()
    }

    override fun saveNews(news: List<Article>): Completable {
        throw UnsupportedOperationException()
    }

    override fun saveSportNews(news: List<Article>): Completable {
        throw UnsupportedOperationException()
    }

    override fun clearAllNews() {
        throw UnsupportedOperationException()
    }

    override fun clearSportNews() {
        throw UnsupportedOperationException()
    }
}