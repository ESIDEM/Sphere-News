package ng.com.techdepo.domain.usecases.specific

import io.reactivex.Flowable
import ng.com.techdepo.domain.repository.NewsRepository
import ng.com.techdepo.domain.usecases.PostExecutionThread
import ng.com.techdepo.domain.usecases.base.FlowableUseCase
import ng.com.techdepo.dto.Article
import javax.inject.Inject

class GetUserImputNews @Inject constructor(private val newsRepository: NewsRepository, private val postExecutionThread: PostExecutionThread) :
    FlowableUseCase<List<Article>, MutableList<String>>(postExecutionThread) {



    override fun buildUseCaseFlowable(params: MutableList<String>?): Flowable<List<Article>> {
        return newsRepository.getUserImput(params!!.get(0),params.get(1),params.get(2))
    }

}