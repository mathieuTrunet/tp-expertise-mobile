package letHimCook.network.data

import kotlinx.serialization.Serializable

@Serializable
data class RecipeShort(
    val id: Int,
    val title: String,
)
