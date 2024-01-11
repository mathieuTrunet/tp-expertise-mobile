
import androidx.compose.ui.window.application
import moe.tlaster.precompose.PreComposeWindow

fun main() =
    application {
        PreComposeWindow(onCloseRequest = ::exitApplication, title = "let him cook") {
            MainView()
        }
    }
