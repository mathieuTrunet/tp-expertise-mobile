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
            println(error.message)
            throw RuntimeException(error.message)
        }
    }
}
