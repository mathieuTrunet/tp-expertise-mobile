
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import views.ingredientSelectionScreen

@Composable
internal fun App() {
    MaterialTheme {
        ingredientSelectionScreen()
    }
}

expect fun getPlatformName(): String
