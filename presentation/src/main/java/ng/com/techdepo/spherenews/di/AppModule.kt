package ng.com.techdepo.spherenews.di

import android.content.Context
import dagger.Module
import dagger.Provides
import ng.com.techdepo.spherenews.SphereNewApp
import javax.inject.Singleton


@Module
class AppModule {


    @Provides
    @Singleton
    fun provideContext(app: SphereNewApp): Context = app.applicationContext


}