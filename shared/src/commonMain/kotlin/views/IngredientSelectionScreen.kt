package views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import components.ingredientBoard
import constants.ingredients
import getPlatformName
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

val isPlatformDesktop: () -> Boolean = { getPlatformName() === "Desktop" }

@OptIn(ExperimentalResourceApi::class)
@Composable
fun ingredientSelectionScreen() {
    var showBottomSheet by remember { mutableStateOf(false) }
    // val sheetState = rememberModalBottomSheetState()

    Row {
        Image(
            painterResource("kitchen-background.jpg"),
            contentDescription = null,
        )
    }

    Row {
        Box(Modifier.weight(2f)) {}
        Column(Modifier.weight(4f), horizontalAlignment = Alignment.CenterHorizontally) {
            Column(Modifier.weight(1.3f)) { }
            Column(Modifier.weight(2f)) {
                Card(elevation = 10.dp, shape = RoundedCornerShape(30)) {
                    Box(Modifier.padding(5.dp)) {
                        Text("let him cook 👨‍🍳", fontSize = 25.sp)
                    }
                }
            }
            Column(Modifier.weight(10f).border(2.dp, Color.Green)) {}
        }
        Box(Modifier.weight(2f)) {}
    }

    Column {
        Row(Modifier.weight(1f)) {}
        Row(
            Modifier.weight(
                if (isPlatformDesktop()) {
                    2.1f
                } else {
                    2.8f
                },
            ),
        ) {
            Surface(
                color = Color(82, 183, 136),
                shape = RoundedCornerShape(topStart = 50.dp, topEnd = 50.dp),
            ) {
                Row {
                    Column(modifier = Modifier.weight(2f)) {}
                    Column(
                        modifier = Modifier.weight(40f),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Box(Modifier.weight(1f)) {}
                        Box(Modifier.weight(6f)) { ingredientBoard(ingredients) }
                        Box(Modifier.weight(0.7f)) {}
                        Box(Modifier.weight(2f)) { sendingButton() }
                    }
                    Column(modifier = Modifier.weight(2f)) {}
                }
            }
        }
    }

    Row {
        Column(Modifier.weight(95f)) {}
        Column(Modifier.weight(20f), horizontalAlignment = Alignment.CenterHorizontally) {
            Box(Modifier.weight(5f)) {}
            Box(Modifier.weight(20f)) {
                helperFab { clicked -> showBottomSheet = clicked }
            }
            Box(Modifier.weight(95f)) {}
        }
        Column(Modifier.weight(5f)) {}
    }
}

@Composable
fun helperFab(onClick: (Boolean) -> Unit) {
    FloatingActionButton(
        onClick = { onClick(true) },
        shape = RoundedCornerShape(40),
        backgroundColor = Color(82, 183, 136),
        contentColor = Color(18, 84, 24),
    ) { Icon(Icons.Filled.Info, "How to do the cookin ?") }
}

@Composable
fun sendingButton() {
    Box(
        Modifier
            .clip(RoundedCornerShape(20.dp))
            .clickable { }.shadow(8.dp)
            .background(
                Brush.linearGradient(
                    listOf(
                        Color(168, 255, 120),
                        Color(120, 255, 214),
                    ),
                ),
                RoundedCornerShape(40),
            )
            .border(2.dp, Color(18, 84, 24), RoundedCornerShape(40))
            .padding(14.dp),
    ) {
        Text("let's do the cookin")
    }
}
