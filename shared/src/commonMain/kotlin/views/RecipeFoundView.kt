package views

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun recipeFoundView() {
    Column {
        Row(Modifier.weight(1f)) { }
        Row(Modifier.weight(1f)) {
            Row(Modifier.weight(1f)) { }
            Row(Modifier.weight(1f).border(1.dp, Color.Red)) {
                Text("yoo")
            }
            Row(Modifier.weight(1f)) { }
        }
        Row(Modifier.weight(1f)) { }
    }
}
