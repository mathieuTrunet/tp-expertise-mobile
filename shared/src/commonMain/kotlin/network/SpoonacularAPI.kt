package network

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import network.data.Recipe

class SpoonacularAPI(private val apiKey: String) {
    private val httpClient =
        HttpClient {
            install(ContentNegotiation) {
                json(json = Json { ignoreUnknownKeys = true })
            }
        }

    suspend fun getRandomRecipes(): List<Recipe> {
        val url = "https://api.spoonacular.com/recipes/random?apiKey=$apiKey"

        return try {
            httpClient.get(url).body()
        } catch (error: Exception) {
            emptyList()
        }
    }
}
