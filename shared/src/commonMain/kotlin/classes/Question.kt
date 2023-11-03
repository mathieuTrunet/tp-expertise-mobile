package classes

data class Question(val id: Int, val label: String, val correctId: List<Answer>)
