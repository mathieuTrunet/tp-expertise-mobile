
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import components.QuestionScreen
import network.QuizRepository

private val repository = QuizRepository()

@Composable
internal fun App() {
    MaterialTheme {
        val questions = repository.questionState.collectAsState()

        if (questions.value.isNotEmpty()) {
            QuestionScreen(questions.value)
        }
    }
}
