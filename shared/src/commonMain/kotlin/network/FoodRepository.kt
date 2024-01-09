package network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.withContext
import network.data.Recipe

class FoodRepository(apiKey: String) {
    private val foodAPI = SpoonacularAPI(apiKey)

    private var _randomRecipe = MutableStateFlow(listOf<Recipe>())
    val randomRecipe = _randomRecipe

    private suspend fun fetchRandomRecipe(): List<Recipe> = foodAPI.getRandomRecipes()

    suspend fun getRandomRecipe() {
        withContext(Dispatchers.IO) { _randomRecipe.update { fetchRandomRecipe() } }
    }
}
