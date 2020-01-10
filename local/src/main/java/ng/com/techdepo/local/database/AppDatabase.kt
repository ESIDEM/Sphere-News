package ng.com.techdepo.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ng.com.techdepo.local.dao.NewsDAO
import ng.com.techdepo.local.entity.NewsEntity

@Database(entities =[ NewsEntity::class],version = 1)
abstract class AppDatabase:RoomDatabase() {

    abstract fun newsDao():NewsDAO
}