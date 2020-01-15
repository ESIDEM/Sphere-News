package ng.com.techdepo.spherenews.mapper




import ng.com.techdepo.dto.Article
import ng.com.techdepo.spherenews.dto.PreSource
import ng.com.techdepo.spherenews.dto.PresentationArticle


class ArticleMapper():Mapper<List<Article>,List<PresentationArticle>> {
    override fun mapFromDomain(type: List<Article>): List<PresentationArticle> {
        return type.map {
            PresentationArticle(
                PreSource(
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