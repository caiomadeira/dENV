import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun EntryColumn(windowState: MutableState<Int>)
{
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.background(Color(0XFFFE2A5F6)).fillMaxHeight().fillMaxSize())
    {
        Box(modifier = Modifier.fillMaxWidth(0.5f))
        {
            Button( modifier = Modifier.background(Color.Transparent),
                onClick = {
                    windowState.value = 2
                }) {
                EntryPointImageCard(
                    painter = painterResource("profile-circle.svg"),
                    contentDescription = "Setup basic programs.",
                    title = "Normal User"
                )
            }
        }

        Box(modifier = Modifier.fillMaxWidth(0.5f))
        {
            Button( modifier = Modifier.background(Color.Transparent),
                onClick = {
                    windowState.value = 3
                }) {
                EntryPointImageCard(
                    painter = painterResource("dev-env.svg"),
                    contentDescription = "Setup enviroment for development.",
                    title = "Dev User"
                )
            }
        }
    }
}