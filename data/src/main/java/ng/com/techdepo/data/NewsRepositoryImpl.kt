package ng.com.techdepo.data

import io.reactivex.Flowable
import ng.com.techdepo.data.source.AppDataStoreFactory
import ng.com.techdepo.domain.repository.NewsRepository
import ng.com.techdepo.dto.Article
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(val factory: AppDataStoreFactory):NewsRepository {

    override fun getAllNewsRemote(country: String, apiKey: String): Flowable<List<Article>> {
        return factory.retrieveRemoteDataStore().getAllNewsRemote(country,apiKey).doOnNext {


        }.doOnError {



        }
    }

    override fun getLocalNews(): Flowable<List<Article>> {
        return factory.retrieveCacheDataStore().getLocalNews()
    }
}