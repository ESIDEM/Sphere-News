package ng.com.techdepo.spherenews.di.component

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import ng.com.techdepo.spherenews.SphereNewApp
import ng.com.techdepo.spherenews.di.modules.ActivityBindingModule
import ng.com.techdepo.spherenews.di.modules.AppModule
import ng.com.techdepo.spherenews.di.modules.NetworkModule
import ng.com.techdepo.spherenews.di.modules.ViewModelModule
import javax.inject.Singleton


@Singleton
@Component(modules = [AndroidSupportInjectionModule::class,
    AppModule::class, NetworkModule::class,ActivityBindingModule::class,ViewModelModule::class])
interface AppComponent:AndroidInjector<DaggerApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: SphereNewApp): Builder

        fun build(): AppComponent
    }

    fun inject(app: SphereNewApp)


}