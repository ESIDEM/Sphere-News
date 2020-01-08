package ng.com.techdepo.spherenews.di

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import ng.com.techdepo.remote.TopHeadlinesEndpoint
import ng.com.techdepo.spherenews.BASE_URL
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


@Module
class NetworkModule {


    @Provides
    @Singleton
    fun moshi(): Moshi {
        return Moshi.Builder().build()
    }


    @Provides
    @Singleton
    fun provideRetrofit(moshi: Moshi): Retrofit = Retrofit.Builder().addConverterFactory(
        MoshiConverterFactory.create(moshi)
    )
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .baseUrl(BASE_URL).build()

    @Provides
    @Singleton
    fun provideAPI(retrofit: Retrofit):TopHeadlinesEndpoint{
        return retrofit.create(TopHeadlinesEndpoint::class.java)
    }

}