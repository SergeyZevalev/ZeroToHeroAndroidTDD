package ru.easycode.zerotoheroandroidtdd

import com.google.gson.annotations.SerializedName

interface Repository {
    suspend fun load(): SimpleResponse
    class Base(
        private val service: SimpleService,
        private val url: String
    ) : Repository {
        override suspend fun load(): SimpleResponse {
            return service.fetch(url)
        }
    }
}

data class SimpleResponse(
    @SerializedName("text")
    private val text: String
) {
    fun text() = text
}