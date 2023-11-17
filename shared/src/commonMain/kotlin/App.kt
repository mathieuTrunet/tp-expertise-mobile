import androidx.compose.animation.AnimatedVisibility
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import classes.Person
import components.CurriculumVitae
import components.WelcomeScreen

@Composable
fun App(person: Person) {
    MaterialTheme {
        var showCurriculumVitae by remember { mutableStateOf(true) }

        AnimatedVisibility(showCurriculumVitae) {
            CurriculumVitae(person)
        }
        WelcomeScreen()
    }
}
