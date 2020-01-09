package ng.com.techdepo.spherenews.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import ng.com.techdepo.domain.usecases.PostExecutionThread
import ng.com.techdepo.spherenews.SphereNewApp
import javax.inject.Singleton


@Module
class AppModule {


    @Provides
    @Singleton
    fun provideContext(app: SphereNewApp): Context = app.applicationContext


}