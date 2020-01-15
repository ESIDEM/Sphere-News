package ng.com.techdepo.spherenews.viewmodels


import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ng.com.techdepo.spherenews.dto.PresentationArticle

class DetailsViewModel(article: PresentationArticle, application: Application):AndroidViewModel(application) {


    private val _selectedArticle = MutableLiveData<PresentationArticle>()
    val selectedArticle: LiveData<PresentationArticle>
        get() = _selectedArticle


    init {
        _selectedArticle.value = article
    }
}