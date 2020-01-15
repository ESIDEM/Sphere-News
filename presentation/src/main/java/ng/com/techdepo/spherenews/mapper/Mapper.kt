package ng.com.techdepo.spherenews.mapper

interface Mapper<T,V> {

    fun mapFromDomain(type: T): V


}