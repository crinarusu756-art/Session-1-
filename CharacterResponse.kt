package com.example.app.model
//
import kotlinx.serialization.Serializable


@Serializable
data class CharacterResponse(

    val results: List<Character>
)