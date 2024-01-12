package letHimCook.network.data

import kotlinx.serialization.Serializable

@Serializable
data class RecipeShort(
    val id: Int,
    val title: String,
    val image: String?,
    val missedIngredients: List<Ingredient>?,
    val usedIngredients: List<Ingredient>?,
    val unusedIngredients: List<Ingredient>?,
)
