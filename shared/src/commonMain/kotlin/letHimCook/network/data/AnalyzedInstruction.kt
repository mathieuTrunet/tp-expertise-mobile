package letHimCook.network.data

import kotlinx.serialization.Serializable

@Serializable
data class AnalyzedInstruction(
    val name: String?,
    val steps: List<Step>,
)
