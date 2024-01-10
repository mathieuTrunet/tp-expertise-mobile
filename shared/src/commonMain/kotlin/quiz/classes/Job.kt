package quiz.classes

data class Job(
    val title: String,
    val description: String,
    val location: String,
    val dates: Pair<Number, Number>,
)
