import java.lang.reflect.Modifier

/*
//Ex1
@Composable
fun Exercise(name: String) {
    Text(
        text = "Hello $name",
        color = Color.Blue
    )
}
//EX2

@Composable
fun MyButton() {
    Button(
        onClick = {
            Log.d("BUTTON", "Clicked")
        }
    ) {
        Text("Click Me")
    }
}
//EX3
@Composable
fun IconTextRow() {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.Home,
            contentDescription = null
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text("Home")
    }
}
//EX4
@Composable
fun TextColumn() {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text("First")
        Text("Second")
        Text("Third")
    }
}

//EX5
@Composable
fun ImageWithText() {
    Box(
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = null
        )

        Text(
            text = "Centered Text",
            color = Color.White
        )
    }
}

//EX6
@Composable
fun RedCircleBox() {
    Box(
        modifier = Modifier
            .size(100.dp)
            .background(Color.Red, shape = CircleShape)
    )
}

//EX7
@Composable
fun CounterButton() {
    var count by remember { mutableStateOf(0) }

    Button(
        onClick = {
            count++
        }
    ) {
        Text("Count: $count")
    }
}

//EX8
@Composable
fun ScrollableColumn() {
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        repeat(20) {
            Text("Item $it")
        }
    }
}

//EX9

*/


