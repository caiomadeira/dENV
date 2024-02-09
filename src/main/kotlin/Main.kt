import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.*
import java.awt.Toolkit

@Composable
fun goToNewWindow() {
    Text("new window")
}

@Composable
fun EntryPointImageCard(
    painter: Painter,
    contentDescription: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Card (
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        elevation = 5.dp
    ) {
        Box(modifier = Modifier.height(80.dp)) {
            Image(painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop
            )
            Box(modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black,
                            Color.Transparent
                        ),
                        startY = 300f
                    )
                )
            )
            Box(modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Text(title,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .shadow(elevation = 5.dp,
                            spotColor = Color.Black),
                    style = TextStyle(
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                ))
            }
        }
    }
}

@Composable
fun UserSetup() {
    Text("User setup")
}

@Composable
fun DevSetup() {
    Text("Dev setup")
}

@Composable
fun MainApp() {
    val windowState: MutableState<Int> = remember { mutableStateOf(1) }

    println("State: $windowState")
    if (windowState.value == 1) {
        EntryView(windowState = windowState)
    }
    if (windowState.value == 2) {
        UserSetup()
    }

    if (windowState.value == 3) {
        DevSetup()
    }
}


@Composable
fun EntryView(windowState: MutableState<Int>) {
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.background(Color(0XFFE2A5F6)))
    {
        Text("What type of user are you?",
            color = Color.Black,
            fontSize = 20.sp,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(20.dp).background(Color.Transparent))

        Row(horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.background(Color.Red).fillMaxSize())
        {
            EntryColumn(windowState)
        }
    }
}


// Precisamos declarar um container (window) com componentes composable que queremos declarar
fun main() = application {
    val screenSize = Toolkit.getDefaultToolkit().screenSize
    val screenWidth = screenSize.width / 2
    val screenHeight = screenSize.height / 2
    println("Width: $screenWidth ; Height: $screenHeight")
    val state = rememberWindowState(
        size = DpSize(screenWidth.dp, screenHeight.dp),
        position = WindowPosition(0.dp, 0.dp),
        placement = WindowPlacement.Floating
    )

    Window(title="Denv", onCloseRequest = ::exitApplication, state = state) {
        MainApp()
    }
}
