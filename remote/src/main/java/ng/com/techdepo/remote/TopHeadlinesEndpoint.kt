package ng.com.techdepo.remote


import io.reactivex.Flowable
import ng.com.techdepo.remote.dto.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query


interface TopHeadlinesEndpoint {


    @GET("top-headlines")
    fun getTopHeadlines(
        @Query("country") country: String,
        @Query("pageSize") pageSize: String,
        @Query("apiKey") apiKey: String
    ): Flowable<ApiResponse>


    @GET("top-headlines")
    fun getSportNews(
        @Query("category") category: String,
        @Query("pageSize") pageSize: String,
        @Query("apiKey") apiKey: String
    ): Flowable<ApiResponse>
}
