package views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import components.IngredientBoard
import ingredients

@Composable
fun IngredientSelectionScreen() {
    Row {
        Column(modifier = Modifier.weight(2f)) {}
        Column(modifier = Modifier.weight(17f), horizontalAlignment = Alignment.CenterHorizontally) {
            Box(Modifier.weight(2f)) { Text("let him cook") }
            Box(Modifier.weight(2f)) {}
            Box(Modifier.weight(4f)) { IngredientBoard(ingredients) }
            Box(Modifier.weight(0.7f)) {}
            Box(Modifier.weight(1.5f)) { Button({ }) { Text("let's cook ") } }
            Box(Modifier.weight(0.7f)) {}
        }
        Column(modifier = Modifier.weight(2f)) {}
    }
    Row {
        Column(Modifier.weight(95f)) {}
        Column(Modifier.weight(10f), horizontalAlignment = Alignment.CenterHorizontally) {
            Box(Modifier.weight(5f)) {}
            Box(Modifier.weight(10f)) {
                HelperFab()
            }
            Box(Modifier.weight(95f)) {}
        }
        Column(Modifier.weight(5f)) {}
    }
}

@Composable
fun HelperFab() {
    FloatingActionButton(
        onClick = {},
        backgroundColor = Color(168, 255, 120),
        contentColor = Color(18, 84, 24),
        shape = RoundedCornerShape(18.dp),
    ) { Icon(Icons.Filled.Info, "How to do the cookin ?") }
}
