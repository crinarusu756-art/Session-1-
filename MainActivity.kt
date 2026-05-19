package com.example.session6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.session6.ui.theme.Session6Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = Home
            ) {
                composable<Home> {
                    HomeScreen(
                        onNavigateToDetail = { id ->
                            navController.navigate(Detail(id))
                        }
                    )
                }
                composable<Detail> { backStackEntry ->
                    DetailScreen(
                        backStackEntry = backStackEntry,
                        onGoBack = { navController.popBackStack() }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreen(onNavigateToDetail: (Int) -> Unit = {}) {
    val items = (1..10).toList()

    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Home",
            modifier = Modifier.padding(16.dp)
        )

        Button(
            onClick = { onNavigateToDetail(123) },
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Text("Go to Detail 123")
        }

        LazyColumn {
            items(items) { id ->
                Text(
                    text = "Item $id",
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onNavigateToDetail(id) }
                        .padding(16.dp)
                )
            }
        }
    }
}

@Composable
fun DetailScreen(
    backStackEntry: NavBackStackEntry,
    onGoBack: () -> Unit
) {
    val detail: Detail = backStackEntry.toRoute()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Detail Screen")
        Text("ID: ${detail.id}")

        Button(onClick = onGoBack) {
            Text("Go Back")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailScreenPreview() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Detail Screen")
        Text("ID: 123")
        Button(onClick = {}) {
            Text("Go Back")
        }
    }
}
