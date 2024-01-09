package network.data

import kotlinx.serialization.Serializable

@Serializable
data class Recipe(
    val id: Int,
    val title: String,
    val image: String,
    val readyInMinutes: Int,
    val servings: Int,
    val sourceUrl: String,
    val summary: String,
    val cuisines: List<String>,
    val dishTypes: List<String>,
    val diets: List<String>,
    val instructions: String,
)
