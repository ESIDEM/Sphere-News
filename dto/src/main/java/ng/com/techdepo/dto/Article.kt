package ng.com.techdepo.dto


data class Article(val source: Source,
              var author: String,
              var title: String,
              var description: String,
              var url: String,
              var urlToImage: String,
              var publishedAt: String,
              var content: String)
