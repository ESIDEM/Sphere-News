package ng.com.techdepo.spherenews


const val BASE_URL = "https://newsapi.org/v2/"

enum class EventState { LOADING, SUCCESS, ERROR }

data class Event<out T> constructor(val eventState: EventState, val data: T? = null, val message: String? = null, val throwable: Throwable? = null)

