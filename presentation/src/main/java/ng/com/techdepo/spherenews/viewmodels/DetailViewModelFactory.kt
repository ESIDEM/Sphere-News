package ng.com.techdepo.spherenews.viewmodels

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ng.com.techdepo.spherenews.dto.PresentationArticle

class DetailViewModelFactory (

    private val article: PresentationArticle,
    private val application: Application) : ViewModelProvider.Factory {
        @Suppress("unchecked_cast")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(DetailsViewModel::class.java)) {
                return DetailsViewModel(article, application) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
}