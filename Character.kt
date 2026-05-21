package com.example.app.model
//
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Character(

    val id: Int,
    val name: String,

    @SerialName("image")
    val imageUrl: String
)