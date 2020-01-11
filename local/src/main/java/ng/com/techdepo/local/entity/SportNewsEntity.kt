package ng.com.techdepo.local.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "port_news")
class SportNewsEntity(@Embedded val source: Source,
                      var author: String?,
                      var title: String?,
                      var description: String?,
                      @PrimaryKey
                      var url: String,
                      var urlToImage: String?,
                      var publishedAt: String?,
                      var content: String?)