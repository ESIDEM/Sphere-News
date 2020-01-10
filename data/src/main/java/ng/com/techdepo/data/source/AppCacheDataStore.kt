package ng.com.techdepo.data.source

import io.reactivex.Completable
import io.reactivex.Flowable
import ng.com.techdepo.data.repository.AppDataStore
import ng.com.techdepo.data.repository.AppLocal
import ng.com.techdepo.dto.Article
import javax.inject.Inject

class AppCacheDataStore @Inject constructor(private val appLocal: AppLocal):AppDataStore {


    override fun getAllNewsRemote(country: String, apiKey: String): Flowable<List<Article>> {
        throw UnsupportedOperationException()
    }

    override fun getLocalNews(): Flowable<List<Article>> {
        return appLocal.getLocalNews()
    }

    override fun saveNews(news: List<Article>): Completable {
        return appLocal.saveNews(news)
    }
}