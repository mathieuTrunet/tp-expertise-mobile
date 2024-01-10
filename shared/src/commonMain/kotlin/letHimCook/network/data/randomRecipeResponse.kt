package letHimCook.network.data

import kotlinx.serialization.Serializable

@Serializable
data class RandomRecipeResponse(var recipes: List<Recipe>)
