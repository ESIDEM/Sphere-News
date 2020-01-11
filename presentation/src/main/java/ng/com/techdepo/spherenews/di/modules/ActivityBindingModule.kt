package ng.com.techdepo.spherenews.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ng.com.techdepo.spherenews.ui.AllNews
import ng.com.techdepo.spherenews.di.scope.FragmentScoped
import ng.com.techdepo.spherenews.ui.SportNews


@Module
abstract class ActivityBindingModule {

    @FragmentScoped
    @ContributesAndroidInjector(modules = [ViewModelModule::class])
    abstract fun allNews(): AllNews

    @FragmentScoped
    @ContributesAndroidInjector(modules = [ViewModelModule::class])
    abstract fun sportNews(): SportNews
}