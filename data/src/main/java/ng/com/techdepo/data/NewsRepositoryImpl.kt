package ng.com.techdepo.data

import io.reactivex.Flowable
import ng.com.techdepo.data.source.AppDataStoreFactory
import ng.com.techdepo.domain.repository.NewsRepository
import ng.com.techdepo.dto.Article
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(val factory: AppDataStoreFactory):NewsRepository {

    override fun getAllNewsRemote(country: String,pageSize: String, apiKey: String): Flowable<List<Article>> {
        return factory.retrieveRemoteDataStore().getAllNewsRemote(country,pageSize,apiKey).doOnNext {


        }.doOnError {



        }
    }

    override fun getSportNewsRemote(
        category: String,
        pageSize: String,
        apiKey: String
    ): Flowable<List<Article>> {
       return factory.retrieveRemoteDataStore().getSportNewsRemote(category,pageSize,apiKey).doOnNext {

       }
    }

    override fun getLocalNews(): Flowable<List<Article>> {
        return factory.retrieveCacheDataStore().getLocalNews()
    }

    override fun getSportNewsLocal(): Flowable<List<Article>> {
       return factory.retrieveCacheDataStore().getSportNewsLocal()
    }

    override fun getUserImput(
        query: String,
        pageSize: String,
        apiKey: String
    ): Flowable<List<Article>> {
        return factory.retrieveRemoteDataStore().getUserSearchImputNews(query,pageSize,apiKey).doOnNext {

        }
    }
}