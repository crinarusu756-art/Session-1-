package com.example.app.api
//
import com.example.app.model.CharacterResponse
import retrofit2.http.GET


interface RickandMortyAPI {

    @GET("character")
    suspend fun getCharacters(): CharacterResponse
}