package letHimCook.routes

import androidx.compose.runtime.Composable
import letHimCook.constants.API_KEY
import letHimCook.network.SpoonacularAPI
import letHimCook.views.ingredientSelectionView
import letHimCook.views.recipeFoundView
import letHimCook.views.recipeView
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.path
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
        scene(
            "/recipe/search/{ingredientList}",
            navTransition = NavTransition(),
        ) { backStackEntry ->
            backStackEntry.path<String>("ingredientList")?.let { ingredientList ->
                recipeFoundView(api, navigator, ingredientList)
            }
        }
        scene("/recipe/{recipeId}", navTransition = NavTransition()) {
                backStackEntry ->
            backStackEntry.path<Int>("recipeId")?.let { recipeId ->
                recipeView(navigator, api, recipeId)
            }
        }
    }
}
