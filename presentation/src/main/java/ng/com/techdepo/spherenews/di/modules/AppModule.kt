package ng.com.techdepo.spherenews.di.modules

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import ng.com.techdepo.data.repository.AppLocal
import ng.com.techdepo.domain.usecases.PostExecutionThread
import ng.com.techdepo.local.AppLocalImpl
import ng.com.techdepo.local.database.AppDatabase
import ng.com.techdepo.remote.AppRemoteImpl
import ng.com.techdepo.spherenews.SphereNewApp
import javax.inject.Singleton


@Module
class AppModule {


    @Provides
    @Singleton
    fun provideContext(app: SphereNewApp): Context = app.applicationContext

    @Provides
    @Singleton
    fun providesAppDatabase(app: SphereNewApp): AppDatabase {
        return Room.databaseBuilder(app.applicationContext, AppDatabase::class.java, "sphere_news_db")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries().build()
    }

    @Provides
    @Singleton
    fun provideAppCache(appLocalImpl:AppLocalImpl): AppLocal = appLocalImpl


}