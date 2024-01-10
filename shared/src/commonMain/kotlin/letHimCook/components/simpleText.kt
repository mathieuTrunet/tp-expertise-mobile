package letHimCook.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import moe.tlaster.precompose.navigation.Navigator

@Composable
fun simpleText(
    text: String,
    navigator: Navigator,
) {
    Row { Text(text) }
}
