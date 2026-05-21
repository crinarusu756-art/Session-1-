package com.example.app.api

import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlin.getValue
import kotlin.jvm.java

//
object Retrofit {

    private const val BASE_URL =
        "https://rickandmortyapi.com/api/"

    private val json = Json {
        ignoreUnknownKeys = true
    }

    val api: RickandMortyAPI by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(
                json.asConverterFactory(
                    "application/json".toMediaType()
                )
            )
            .build()
            .create(RickandMortyAPI::class.java)
    }
}
