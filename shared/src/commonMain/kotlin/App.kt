
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import views.IngredientSelectionScreen

@Composable
internal fun App() {
    MaterialTheme {
        IngredientSelectionScreen()
    }
}
