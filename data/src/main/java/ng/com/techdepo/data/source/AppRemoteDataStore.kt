package ng.com.techdepo.data.source

import io.reactivex.Completable
import io.reactivex.Flowable
import ng.com.techdepo.data.repository.AppRemote
import ng.com.techdepo.data.repository.AppDataStore
import ng.com.techdepo.data.repository.AppLocal
import ng.com.techdepo.dto.Article
import javax.inject.Inject

class AppRemoteDataStore @Inject constructor(val remote: AppRemote, val appLocal: AppLocal):AppDataStore {

    override fun getAllNewsRemote(country: String, apiKey: String): Flowable<List<Article>> {
        return remote.getAllNewsRemote(country,apiKey).doOnNext {

            appLocal.saveNews(it).subscribe()

        }
    }

    override fun getLocalNews(): Flowable<List<Article>> {
        throw UnsupportedOperationException()
    }

    override fun saveNews(news: List<Article>): Completable {
        throw UnsupportedOperationException()
    }
}