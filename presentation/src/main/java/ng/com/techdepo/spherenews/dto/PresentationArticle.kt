package ng.com.techdepo.spherenews.dto


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PresentationArticle(
    val source: PreSource,
    var author: String?,
    var title: String?,
    var description: String?,
    var url: String,
    var urlToImage: String?,
    var publishedAt: String?,
    var content: String?
) : Parcelable {
}