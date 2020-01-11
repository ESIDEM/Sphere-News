package ng.com.techdepo.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ng.com.techdepo.local.dao.NewsDAO
import ng.com.techdepo.local.dao.SportNewsDAO
import ng.com.techdepo.local.entity.NewsEntity
import ng.com.techdepo.local.entity.SportNewsEntity

@Database(entities =[ NewsEntity::class,SportNewsEntity::class],version = 1)
abstract class AppDatabase:RoomDatabase() {

    abstract fun newsDao():NewsDAO
    abstract fun sportNewsDao():SportNewsDAO
}