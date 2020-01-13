package ng.com.techdepo.remote

import io.reactivex.Flowable
import ng.com.techdepo.data.repository.AppRemote
import ng.com.techdepo.dto.Article
import javax.inject.Inject

class AppRemoteImpl @Inject constructor(val topHeadlinesEndpoint: TopHeadlinesEndpoint):AppRemote {

    override fun getAllNewsRemote(country: String,pageSize:String, apiKey: String): Flowable<List<Article>> {
        return  topHeadlinesEndpoint.getTopHeadlines(country,pageSize,apiKey).map {

            it.articles
        }
    }

    override fun getSportNewsRemote(
        category: String,
        pageSize: String,
        apiKey: String
    ): Flowable<List<Article>> {
        return topHeadlinesEndpoint.getSportNews(category,pageSize,apiKey).map {
            it.articles
        }
    }

    override fun getUserSearchImputNews(
        query: String,
        pageSize: String,
        apiKey: String
    ): Flowable<List<Article>> {
        return topHeadlinesEndpoint.getUserSearchInput(query,pageSize,apiKey).map {
            it.articles
        }
    }
}