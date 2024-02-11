import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
        verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterVertically),
        modifier = Modifier.background(Color(0XFFFE2A5F6)).fillMaxHeight().fillMaxSize())
    {
        Box(modifier = Modifier
            .height(140.dp).width(140.dp)
            .clickable {
                windowState.value = 2
            }) {
            ImageCard(
                painter = painterResource("profile-circle.svg"),
                contentDescription = "Setup basic programs.",
                title = "Normal User")
        }

        Box(modifier = Modifier
            .height(140.dp).width(140.dp)
            .clickable {
                windowState.value = 3
            }) {
            ImageCard(
                painter = painterResource("dev-env.svg"),
                contentDescription = "Setup enviroment for development.",
                title = "Dev User")
        }
    }
}