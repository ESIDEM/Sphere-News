package ng.com.techdepo.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Flowable
import ng.com.techdepo.local.entity.NewsEntity

@Dao
interface NewsDAO {


    @Query("SELECT * FROM news")
    fun getNewsFeeds(): Flowable<List<NewsEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveNewsFeeds(news: List<NewsEntity>)
}