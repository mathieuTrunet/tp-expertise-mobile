
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import letHimCook.routes.navigation

@Composable
internal fun App() {
    MaterialTheme {
        navigation()
    }
}

expect fun getPlatformName(): String
