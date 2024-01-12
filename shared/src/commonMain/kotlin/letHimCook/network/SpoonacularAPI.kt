package letHimCook.network

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import letHimCook.network.data.RandomRecipeResponse
import letHimCook.network.data.Recipe
import letHimCook.network.data.RecipeShort
import letHimCook.network.data.SimilarRecipe

class SpoonacularAPI(private val apiKey: String) {
    private val httpClient =
        HttpClient {
            install(ContentNegotiation) {
                json(
                    contentType = ContentType.Application.Json,
                    json =
                        Json {
                            ignoreUnknownKeys = true
                        },
                )
            }
        }

    suspend fun getRandomRecipe(): Recipe {
        val url = "https://api.spoonacular.com/recipes/random?apiKey=$apiKey"

        return try {
            httpClient.get(url).body<RandomRecipeResponse>().recipes.first()
        } catch (error: Exception) {
            println(error.cause)
            throw RuntimeException(error.message)
        }
    }

    suspend fun getRecipeIdListFromIngredient(formattedIngredientList: String): List<RecipeShort> {
        val url = "https://api.spoonacular.com/recipes/findByIngredients?apiKey=$apiKey&number=20&ingredients=$formattedIngredientList"

        return try {
            httpClient.get(url).body<List<RecipeShort>>()
        } catch (error: Exception) {
            println(error.cause)
            throw RuntimeException(error.message)
        }
    }

    suspend fun getSimilarRecipeList(recipeId: Int): List<SimilarRecipe> {
        val url = "https://api.spoonacular.com/recipes/$recipeId/similar?apiKey=$apiKey&number=8"

        return try {
            httpClient.get(url).body<List<SimilarRecipe>>()
        } catch (error: Exception) {
            println(error.cause)
            throw RuntimeException(error.message)
        }
    }

    suspend fun getRecipeById(recipeId: Int): Recipe {
        val url = "https://api.spoonacular.com/recipes/$recipeId/information?apiKey=$apiKey&includeNutrition=false"

        return try {
            httpClient.get(url).body<Recipe>()
        } catch (error: Exception) {
            println(error.cause)
            throw RuntimeException(error.message)
        }
    }
}
