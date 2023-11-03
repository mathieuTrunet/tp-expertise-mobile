import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import classes.Education
import classes.Job
import classes.Person
import classes.Skill
import components.CurriculumVitae

// actual fun getPlatformName(): String = "Desktop"

val listOfSkills = listOf<Skill>(
    Skill("typescript"),
    Skill("python"),
    Skill("linux"),
    Skill("trapèze"),
)

val listOfEducations = listOf<Education>(
    Education("école élémentaire Britney Spears", "apprentissage du francais et du mandarin", "Paris", Pair(2002, 2004)),
    Education("enfant prodige", "démonstration infantile d'intelligence surhumaine", "Quimper", Pair(2004, 2016)),
    Education("Lycée public Christian Clavier", "Bac général S", "Montcucq", Pair(2016, 2019)),
)

val listOfJobs = listOf<Job>(
    Job("developpeur", "conception et développement d'applications web", "Lille, France", Pair(2021, 2022)),
    Job("vendeur de légumes", "vente sur le marché de produits alimentaires", "Bangkok", Pair(2022, 2023)),
    Job("trapéziste", "balancement de manière artistique", "Rio de Janeiro", Pair(2023, 2023)),
)

val person = Person(
    "Mathieu",
    "Trunet",
    "développeur fullStack",
    "06 05 15 08 08",
    "mathieu1508@gmail.com",
    "image-mathieu.png",
    listOfSkills,
    listOfEducations,
    listOfJobs,
)

@Composable fun MainView() = App(person)

@Preview
@Composable
fun AppPreview() {
    CurriculumVitae(person)
}
