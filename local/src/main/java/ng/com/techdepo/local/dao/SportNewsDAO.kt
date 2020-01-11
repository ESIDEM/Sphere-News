package ng.com.techdepo.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Flowable
import ng.com.techdepo.local.entity.SportNewsEntity


@Dao
interface SportNewsDAO {


    @Query("SELECT * FROM port_news")
    fun getSportNews(): Flowable<List<SportNewsEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveSportNews(news: List<SportNewsEntity>)
}