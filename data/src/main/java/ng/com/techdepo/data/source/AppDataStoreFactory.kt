package ng.com.techdepo.data.source

import javax.inject.Inject

class AppDataStoreFactory @Inject constructor(private val appRemoteDataStore: AppRemoteDataStore) {

    /**
     * Return an instance of Remote Data Store
     */
    open fun retrieveRemoteDataStore(): AppRemoteDataStore {
        return appRemoteDataStore
    }
}