package ng.com.techdepo.spherenews.di

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.AndroidSupportInjectionModule
import ng.com.techdepo.spherenews.SphereNewApp
import javax.inject.Singleton


@Singleton
@Component(modules = [AndroidSupportInjectionModule::class,
    AppModule::class,NetworkModule::class])
interface AppComponent:AndroidInjector<DaggerApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: SphereNewApp): Builder

        fun build(): AppComponent
    }

    fun inject(app: SphereNewApp)
}