package letHimCook.routes

import androidx.compose.runtime.Composable
import letHimCook.constants.API_KEY
import letHimCook.network.SpoonacularAPI
import letHimCook.views.ingredientSelectionView
import letHimCook.views.recipeFoundView
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.rememberNavigator
import moe.tlaster.precompose.navigation.transition.NavTransition

private val api = SpoonacularAPI(API_KEY)

@Composable
internal fun navigation() {
    val navigator = rememberNavigator()

    NavHost(navigator = navigator, navTransition = NavTransition(), initialRoute = "/ingredient/selection") {
        scene(
            "/ingredient/selection",
            navTransition = NavTransition(),
        ) {
            ingredientSelectionView(navigator)
        }
        scene("/recipe", navTransition = NavTransition()) {
            recipeFoundView(api, navigator)
        }
    }
}
