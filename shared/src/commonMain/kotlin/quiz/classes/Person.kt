package quiz.classes

data class Person(
    val firstName: String,
    val lastName: String,
    val job: String,
    val telephone: String,
    val mail: String,
    val pictureName: String,
    val skills: List<Skill>?,
    val educations: List<Education>?,
    val jobs: List<Job>?,
)
