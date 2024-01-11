package letHimCook.network.data

import kotlinx.serialization.Serializable

@Serializable
data class Step(
    val number: Int,
    val step: String,
)
