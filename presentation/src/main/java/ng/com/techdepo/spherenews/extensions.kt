package ng.com.techdepo.spherenews

import android.text.format.DateUtils
import java.text.SimpleDateFormat
import java.util.*


const val BASE_URL = "https://newsapi.org/v2/"

enum class EventState { LOADING, SUCCESS, ERROR }

data class Event<out T> constructor(val eventState: EventState, val data: T? = null, val message: String? = null, val throwable: Throwable? = null)

fun timeAgo(dateString :String):String{

    val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
    val date: Date = inputFormat.parse(dateString.replace("Z",""))

    return DateUtils.getRelativeTimeSpanString(date.getTime(),
        Calendar.getInstance()
            .getTimeInMillis(),
        DateUtils.MINUTE_IN_MILLIS).toString()
}
