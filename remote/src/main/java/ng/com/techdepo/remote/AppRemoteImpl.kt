package ng.com.techdepo.remote

import io.reactivex.Flowable
import ng.com.techdepo.data.repository.AppRemote
import ng.com.techdepo.dto.Article
import javax.inject.Inject

class AppRemoteImpl @Inject constructor(val topHeadlinesEndpoint: TopHeadlinesEndpoint):AppRemote {

    override fun getAllNewsRemote(country: String, apiKey: String): Flowable<List<Article>> {
        return  topHeadlinesEndpoint.getTopHeadlines(country,apiKey).map {
            it.articles
        }
    }
}