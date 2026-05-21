package com.example.app.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app.api.Retrofit

import kotlinx.coroutines.launch

class CharacterViewModel : ViewModel() {

    var uiState by mutableStateOf<UiState>(
        UiState.Loading
    )
        private set

    init {
        getCharacters()
    }
    private fun getCharacters() {

        viewModelScope.launch {
            try {
                val response =
                    Retrofit.api.getCharacters()

                uiState = UiState.Success(
                    response.results
                )

            } catch (e: Exception) {

                uiState = UiState.Error(
                    e.message ?: "Unknown Error"
                )
            }
        }
    }
}