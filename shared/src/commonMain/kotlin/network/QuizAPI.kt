package network

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import network.data.Answer
import network.data.Question
import network.data.Quiz

class QuizAPI {
    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(
                contentType = ContentType.Text.Plain, // because Github is not returning an 'application/json' header
                json = Json {
                    ignoreUnknownKeys = true
                    useAlternativeNames = false
                },
            )
        }
    }
    suspend fun getAllQuestions(): Quiz {
        return try { httpClient.get("https://awl.li/devoxxkmm2023").body() } catch (error: Exception) {
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
