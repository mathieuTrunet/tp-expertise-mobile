package views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import components.IngredientBoard
import ingredients

@Composable
fun IngredientSelectionScreen() {
    Column(
        modifier = Modifier.fillMaxHeight().fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Column(Modifier.weight(2f, true)) { Text("let him cook") }
        Column(Modifier.weight(5f, true)) { }
        Column(Modifier.weight(3f)) { IngredientBoard(ingredients) }
    }
}
