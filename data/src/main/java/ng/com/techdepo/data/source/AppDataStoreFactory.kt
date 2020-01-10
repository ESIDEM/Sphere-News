package ng.com.techdepo.data.source

import javax.inject.Inject

class AppDataStoreFactory @Inject constructor(private val appRemoteDataStore: AppRemoteDataStore,
                                              private val appCacheDataStore: AppCacheDataStore) {

    /**
     * Return an instance of Cache Data Store
     */
    open fun retrieveCacheDataStore(): AppCacheDataStore {
        return appCacheDataStore
    }


    /**
     * Return an instance of Remote Data Store
     */
    open fun retrieveRemoteDataStore(): AppRemoteDataStore {
        return appRemoteDataStore
    }
}