package ru.easycode.zerotoheroandroidtdd

import java.net.UnknownHostException

interface Repository {

    suspend fun load(): LoadResult

    class Base(
        private val service: SimpleService,
        private val url: String
    ) : Repository {
        override suspend fun load(): LoadResult {
            return try {
                service.fetch(url).map()
            } catch (e: Exception){
                if (e is UnknownHostException) LoadResult.Error(true)
                else LoadResult.Error(false)
            }
        }

    }
}