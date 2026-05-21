package com.example.app.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.app.viewmodel.CharacterViewModel
import com.example.app.viewmodel.UiState
import jdk.javadoc.internal.doclets.formats.html.markup.Text
import java.lang.reflect.Modifier
import javax.swing.Box
import javax.swing.text.StyleConstants.Alignment

@Composable
fun CharacterScreen(
    viewModel: CharacterViewModel = viewModel()
) {

    val state = viewModel.UiState
    when (state) {

        UiState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {

                CircularProgressIndicator()
            }
        }
        is UiState.Success -> {
            LazyColumn {
                items(state.characters) { character ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            AsyncImage(
                                model = character.imageUrl,
                                contentDescription = null,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(250.dp)
                            )
                            Spacer(
                                modifier = Modifier.height(8.dp)
                            )
                            Text(
                                text = character.name
                            )
                        }
                    }
                }
            }
        }

        is UiState.Error -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = state.message
                )
            }
        }
    }
}