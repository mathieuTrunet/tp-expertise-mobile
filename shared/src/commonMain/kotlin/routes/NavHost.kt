package routes

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import components.QuestionScreen
import components.ScoreScreen
import components.WelcomeScreen
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.path
import moe.tlaster.precompose.navigation.rememberNavigator
import moe.tlaster.precompose.navigation.transition.NavTransition
import network.QuizRepository

private val quizRepository = QuizRepository()

@Composable
internal fun rootNavHost() {
    val navigator = rememberNavigator()
    NavHost(
        navigator = navigator,
        navTransition = NavTransition(),
        initialRoute = "/welcome",
    ) {
        scene(
            route = "/welcome",
            navTransition = NavTransition(),
        ) {
            WelcomeScreen(navigator)
        }
        scene(
            route = "/quiz",
            navTransition = NavTransition(),
        ) {
            val questions = quizRepository.questionState.collectAsState()

            if (questions.value.isNotEmpty()) {
                QuestionScreen(navigator, questions.value)
            }
        }
        scene(
            route = "/score/{score}",
            navTransition = NavTransition(),
        ) { backStackEntry ->
            backStackEntry.path<String>("score")?.let { score ->
                ScoreScreen(navigator, score)
            }
        }
    }
}
