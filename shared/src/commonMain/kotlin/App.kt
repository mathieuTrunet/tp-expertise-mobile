
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import views.ingredientSelectionView

@Composable
internal fun App() {
    MaterialTheme {
        ingredientSelectionView()
    }
}

expect fun getPlatformName(): String
