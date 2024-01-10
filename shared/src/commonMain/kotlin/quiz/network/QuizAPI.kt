package quiz.network

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import quiz.network.data.Answer
import quiz.network.data.Question
import quiz.network.data.Quiz

class QuizAPI {
    private val httpClient =
        HttpClient {
            install(ContentNegotiation) {
                json(
                    contentType = ContentType.Text.Plain,
                    json =
                        Json {
                            ignoreUnknownKeys = true
                            useAlternativeNames = false
                        },
                )
            }
        }

    suspend fun getAllQuestions(): Quiz {
        val url = "https://raw.githubusercontent.com/worldline/learning-kotlin-multiplatform/main/quiz.json"
        return try {
            httpClient.get(url).body()
        } catch (
            error: Exception,
        ) {
            Quiz(
                listOf(
                    Question(
                        1,
                        "est ce que ?",
                        2,
                        listOf(Answer(1, "oui"), Answer(2, "non")),
                    ),
                ),
            )
        }
    }
}
