package com.example.app.viewmodel

import com.example.app.model.Character

sealed interface UiState {

    object Loading : UiState

    data class Success(
        val characters: List<Character>
    ) : UiState

    data class Error(
        val message: String
    ) : UiState
}