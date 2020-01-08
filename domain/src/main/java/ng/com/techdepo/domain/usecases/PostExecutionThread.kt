package ng.com.techdepo.domain.usecases

import io.reactivex.Scheduler

interface PostExecutionThread {

    val scheduler:Scheduler
}