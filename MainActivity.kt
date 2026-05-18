package com.example.session5

import android.R.attr.name
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.session5.ui.theme.Session5Theme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApp()
                }
            }
        }

@Composable
fun MyApp() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {

        BrokenCheckbox()
        WorkingCheckbox()
        TextFieldExample()
        HoistingExample()
        ValidationExample()
        SwitchExample()
        SaveableExample()
        ScrollButtonExample()
        LaunchedEffectExample()
    }
}
//EX1
@Composable
fun BrokenCheckbox() {

    var checked = false

    Row(verticalAlignment = Alignment.CenterVertically) {

        Checkbox(
            checked = checked,
            onCheckedChange = {
                checked = it
            }
        )

        Text("Broken Checkbox")
    }
}

//EX2
@Composable
fun WorkingCheckbox() {

    var checked by remember {
        mutableStateOf(false)
    }

    Row(verticalAlignment = Alignment.CenterVertically) {

        Checkbox(
            checked = checked,
            onCheckedChange = {
                checked = it
            }
        )

        Text("Working Checkbox")
    }
}

//EX3
@Composable
fun TextFieldExample() {

    var text by remember {
        mutableStateOf("")
    }

    Column {
        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Enter name") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text("Hello $text")
    }
}

//EX4
@Composable
fun NameInput(value: String, onValueChange: (String) -> Unit) {

    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text("Name") }
    )
}

@Composable
fun HoistingExample() {

    var name by remember { mutableStateOf("") }

    Column {
        NameInput(
            value = name,
            onValueChange = {
                name = it
            }
        )
        Text("Typing: $name")
    }
}

//EX5
@Composable
fun ValidationExample() {

    var text by remember {
        mutableStateOf("")
    }

    Column {
        TextField(
            value = text,
            onValueChange = {
                text = it
            },
            label = {
                Text("Minimum 3 chars")
            }
        )
        if (text.length < 3) {

            Text(
                text = "Too short!",
                color = Color.Red
            )
        }
    }
}

//EX6
@Composable
fun SwitchExample() {

    var darkMode by remember {
        mutableStateOf(false)
    }

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Switch(
            checked = darkMode,
            onCheckedChange = {
                darkMode = it
            }
        )
        Spacer(modifier = Modifier.width(8.dp))

        Text(
            if (darkMode) "Dark Mode"
            else "Light Mode"
        )
    }
}

//EX7
@Composable
fun SaveableExample() {

    var text by rememberSaveable {
        mutableStateOf("")
    }

    Column {
        TextField(
            value = text,
            onValueChange = {
                text = it
            },
            label = {
                Text("Survives rotation")
            }
        )
        Text("Saved: $text")
    }
}

//EX8
@Composable
fun ScrollButtonExample() {

    val listState = rememberLazyListState()
    val items = (1..30).map {
        "Item $it"
    }

    Box {
        LazyColumn(
            state = listState,
            modifier = Modifier.height(250.dp)
        ) {
            items(items) { item ->

                Text(
                    text = item,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }

        if (listState.firstVisibleItemIndex > 0) {

            Button(
                onClick = {},
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp)
            ) {
                Text("Top")
            }
        }
    }
}
//EX9
@Composable
fun LaunchedEffectExample() {
    var visible by remember {
        mutableStateOf(true)
    }
    LaunchedEffect(key1 = visible) {
        delay(3000)
        visible = false
    }
    if(visible){
        Text("Visible text")
    }
}


























