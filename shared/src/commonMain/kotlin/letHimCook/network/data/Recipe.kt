package letHimCook.network.data

import kotlinx.serialization.Serializable

@Serializable
data class Recipe(
    val id: Int,
    val title: String,
    val readyInMinutes: Int,
    val servings: Int,
    val vegetarian: Boolean,
    val vegan: Boolean,
    val image: String,
    val analyzedInstructions: List<AnalyzedInstruction>,
    val extendedIngredients: List<Ingredient>,
)
