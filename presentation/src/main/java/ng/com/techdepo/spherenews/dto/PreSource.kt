package ng.com.techdepo.spherenews.dto

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PreSource(var id: String?, var name: String?) : Parcelable {
}