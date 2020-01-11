package ng.com.techdepo.spherenews.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ng.com.techdepo.data.NewsRepositoryImpl
import ng.com.techdepo.domain.repository.NewsRepository
import ng.com.techdepo.domain.usecases.PostExecutionThread
import ng.com.techdepo.spherenews.UiThread
import ng.com.techdepo.spherenews.ViewModelKey
import ng.com.techdepo.spherenews.viewmodels.NewsViewModel
import ng.com.techdepo.spherenews.viewmodels.SportNewsViewModel
import ng.com.techdepo.spherenews.viewmodels.ViewModelFactory

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    abstract fun bindPostRepository(newsRepositoryImpl: NewsRepositoryImpl): NewsRepository

@Binds
abstract fun bind(uiThread: UiThread):PostExecutionThread

    @Binds
    @IntoMap
    @ViewModelKey(NewsViewModel::class)
    internal abstract fun overViewViewModel(viewModel: NewsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SportNewsViewModel::class)
    internal abstract fun sportViewModel(viewModel: SportNewsViewModel): ViewModel
}