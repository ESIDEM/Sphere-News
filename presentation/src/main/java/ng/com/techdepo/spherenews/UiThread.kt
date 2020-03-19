package ng.com.techdepo.spherenews

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import ng.com.techdepo.domain.usecases.PostExecutionThread
import javax.inject.Inject

class UiThread @Inject constructor():PostExecutionThread {
    override val scheduler: Scheduler
        get() = AndroidSchedulers.mainThread()
}