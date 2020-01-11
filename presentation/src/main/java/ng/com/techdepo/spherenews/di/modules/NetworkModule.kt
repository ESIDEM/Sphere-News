package ng.com.techdepo.spherenews.di.modules

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import ng.com.techdepo.data.repository.AppRemote
import ng.com.techdepo.domain.usecases.PostExecutionThread
import ng.com.techdepo.remote.AppRemoteImpl
import ng.com.techdepo.remote.TopHeadlinesEndpoint
import ng.com.techdepo.spherenews.BASE_URL
import ng.com.techdepo.spherenews.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
class NetworkModule {

    private val CONNECT_TIMEOUT = 10L
    private val READ_TIMEOUT = 10L
    private val WRITE_TIMEOUT = 10L


    @Provides
    @Singleton
    fun moshi(): Moshi {
        return Moshi.Builder().build()
    }

    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT)
        val clientBuilder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            clientBuilder.addInterceptor(httpLoggingInterceptor)
        }
        clientBuilder.connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
        clientBuilder.writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
        clientBuilder.readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
        return clientBuilder.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient,moshi: Moshi): Retrofit = Retrofit.Builder().addConverterFactory(
        MoshiConverterFactory.create(moshi)
    )
        .client(okHttpClient)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .baseUrl(BASE_URL).build()

    @Provides
    @Singleton
    fun provideAPI(retrofit: Retrofit):TopHeadlinesEndpoint{
        return retrofit.create(TopHeadlinesEndpoint::class.java)
    }

    @Provides
    @Singleton
    fun provideAppRemote(appRemoteImpl: AppRemoteImpl): AppRemote = appRemoteImpl




}