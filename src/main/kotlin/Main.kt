import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.AlignmentLine
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
fun ImageCard(
    painter: Painter,
    contentDescription: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Card (
        modifier = modifier.fillMaxWidth().fillMaxHeight(),
        shape = RoundedCornerShape(8.dp),
        elevation = 5.dp
    ) {
        Box(modifier = Modifier.height(80.dp)) {
            Image(painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Fit,
                colorFilter = ColorFilter.tint(Color(0XFFE2A5F6)),
                modifier = Modifier.padding(18.dp)
            )
            Surface(
                color = Color.Red.copy(alpha = 0.2f),
                modifier = Modifier.fillMaxSize()
            ) {
                Box(modifier = Modifier
                    .fillMaxSize()
                    .background(Brush.verticalGradient(colors = listOf(Color.Transparent, Color.Black, Color.Transparent), startY = 300f))
                )
                Box(modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp),
                    contentAlignment = Alignment.BottomStart
                ) {
                    Text(title,
                        textAlign = TextAlign.Center,
//                        modifier = Modifier
//                            .shadow(elevation = 8.dp,
//                                spotColor = Color.Black),
                        style = TextStyle(
                            color = Color(0xFF9059C9),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Normal,
                        ))
                }
            }
        }
    }
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
        UserSetupView()
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
        Text("ENVIRONMENT SETUP",
            color = Color(0xFF9059C9),
            fontSize = 20.sp,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .background(Color.Transparent)
                .padding(vertical = 16.dp))

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
    val screenWidth = screenSize.width
    val screenHeight = screenSize.height
    println("Monitor - Width: $screenWidth ; Height: $screenHeight")
    val state = rememberWindowState(
        size = DpSize(screenWidth.dp / 4, screenHeight.dp / 2),
        position = WindowPosition(904.6.dp, 270.dp),
        placement = WindowPlacement.Floating,
        isMinimized = false
    )

    println("Window - Width: ${screenWidth.dp / 4} ; Height: ${screenHeight.dp / 2}")

    Window(title="Denv", onCloseRequest = ::exitApplication, state = state) {
        MainApp()
    }
}
