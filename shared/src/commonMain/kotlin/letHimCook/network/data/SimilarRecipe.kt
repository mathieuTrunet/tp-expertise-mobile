package letHimCook.network.data

import kotlinx.serialization.Serializable

@Serializable
data class SimilarRecipe(
    val id: Int,
    val title: String,
)
