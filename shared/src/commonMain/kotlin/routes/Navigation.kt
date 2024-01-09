package routes

import androidx.compose.runtime.Composable
import constants.API_KEY
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.rememberNavigator
import moe.tlaster.precompose.navigation.transition.NavTransition
import network.FoodRepository
import network.data.Recipe
import views.ingredientSelectionView
import views.recipeFoundView

private val foodRepository = FoodRepository(API_KEY)

@Composable
internal fun navigation() {
    val navigator = rememberNavigator()

    NavHost(navigator = navigator, navTransition = NavTransition(), initialRoute = "/ingredient/selection") {
        scene(
            "/ingredient/selection",
            navTransition = NavTransition(),
        ) {
            ingredientSelectionView()
        }
        scene("/recipe/by-ingredients", navTransition = NavTransition()) {
            val randomRecipe = foodRepository.
            recipeFoundView()
        }
    }
}
