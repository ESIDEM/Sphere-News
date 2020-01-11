package ng.com.techdepo.local

import io.reactivex.Completable
import io.reactivex.Flowable
import ng.com.techdepo.data.repository.AppLocal
import ng.com.techdepo.dto.Article
import ng.com.techdepo.dto.Source
import ng.com.techdepo.local.database.AppDatabase
import ng.com.techdepo.local.entity.NewsEntity
import ng.com.techdepo.local.entity.SportNewsEntity
import javax.inject.Inject

class AppLocalImpl @Inject constructor(private val appDatabase: AppDatabase):AppLocal {
    override fun getLocalNews(): Flowable<List<Article>> {
        return appDatabase.newsDao().getNewsFeeds().map {
            it.map {
                Article(
                    Source(
                        it.source.id,
                        it.source.name
                    ),
                    it.author,
                    it.title,
                    it.description,
                    it.url,
                    it.urlToImage,
                    it.publishedAt,
                    it.content

                )
            }
        }
    }

    override fun getSportNewsLocal(): Flowable<List<Article>> {
        return appDatabase.sportNewsDao().getSportNews().map {
            it.map {
                Article(
                    Source(
                        it.source.id,
                        it.source.name
                    ),
                    it.author,
                    it.title,
                    it.description,
                    it.url,
                    it.urlToImage,
                    it.publishedAt,
                    it.content

                )
            }
        }
    }

    override fun saveNews(news: List<Article>): Completable {
      return Completable.fromAction{
          appDatabase.newsDao().saveNewsFeeds(news.map {
              NewsEntity(
                  ng.com.techdepo.local.entity.Source(
                      it.source.id,
                      it.source.name
                  ),
                  it.author,
                  it.title,
                  it.description,
                  it.url,
                  it.urlToImage,
                  it.publishedAt,
                  it.content
              )
          })
      }
    }

    override fun saveSportNews(news: List<Article>): Completable {
        return Completable.fromAction{
            appDatabase.sportNewsDao().saveSportNews(news.map {
                SportNewsEntity(
                    ng.com.techdepo.local.entity.Source(
                        it.source.id,
                        it.source.name
                    ),
                    it.author,
                    it.title,
                    it.description,
                    it.url,
                    it.urlToImage,
                    it.publishedAt,
                    it.content
                )
            })
        }
    }
}