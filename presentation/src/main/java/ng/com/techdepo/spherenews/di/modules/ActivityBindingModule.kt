package ng.com.techdepo.spherenews.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ng.com.techdepo.spherenews.ui.AllNews
import ng.com.techdepo.spherenews.di.scope.FragmentScoped


@Module
abstract class ActivityBindingModule {

    @FragmentScoped
    @ContributesAndroidInjector(modules = [ViewModelModule::class])
    abstract fun allNews(): AllNews
}