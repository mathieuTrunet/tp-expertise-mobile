import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App() {
    MaterialTheme {
        Row{
            Column(Modifier.fillMaxHeight().weight(4f).background(Color(0xFF00994C))) {

                Image(painterResource(
                    "image-mathieu.png"),
                    contentDescription = null,
                    modifier = Modifier.border(2.dp, Color.Yellow).clip(RoundedCornerShape(50.dp))
                    )
                Text("Mathieu TRUNET")
                Text("un magicien de l'ordinateur")
            }
            Column(Modifier.border(2.dp, Color.Blue).fillMaxHeight().weight(8f).background(Color.White)) {
                Text("jjj")

            }
        }
    }
}

expect fun getPlatformName(): String