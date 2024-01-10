package quiz.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import quiz.classes.Education
import quiz.classes.Job
import quiz.classes.Person
import quiz.classes.Skill

@OptIn(ExperimentalResourceApi::class)
@Composable
fun CurriculumVitae(person: Person) {
    MaterialTheme {
        Row {
            Column(Modifier.fillMaxHeight().weight(4f).background(Color(0xFF00994C))) {
                Image(
                    painterResource(
                        person.pictureName,
                    ),
                    contentDescription = null,
                    modifier = Modifier.clip(AbsoluteRoundedCornerShape(50.dp)),
                )
                Column(Modifier.padding(start = 6.dp)) {
                    Text(
                        "${person.firstName} ${person.lastName}",
                        fontWeight = FontWeight.Bold,
                        fontSize = 19.sp,
                    )
                    Text(person.telephone)
                    Text(person.mail)
                    Text(person.job)
                }
                Column(
                    Modifier.padding(2.dp).border(
                        2.dp,
                        Color.White,
                        RoundedCornerShape(10),
                    ).padding(4.dp).fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        "compétences",
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp,
                    )
                    person.skills?.forEach { skill ->
                        CurriculumVitaeSkillSection(skill)
                    }
                }
            }
            Column(Modifier.fillMaxHeight().weight(8f).background(Color.White)) {
                Text(
                    "Etudes",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                )

                person.educations?.forEach { education ->
                    Column(
                        Modifier.fillMaxHeight().weight(3f).padding(4.dp)
                            .border(
                                2.dp,
                                Color(0xFF00994C),
                                RoundedCornerShape(10),
                            ).padding(4.dp).fillMaxWidth(),
                    ) {
                        CurriculumVitaeEducationSection(education)
                    }
                }
                Text(
                    "Expériences",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                )

                person.jobs?.forEach { job ->
                    Column(
                        Modifier.fillMaxHeight().weight(3f).padding(4.dp)
                            .border(
                                2.dp,
                                Color(0xFF00994C),
                                RoundedCornerShape(10),
                            ).padding(4.dp).fillMaxWidth(),
                    ) {
                        CurriculumVitaeJobSection(job)
                    }
                }
            }
        }
    }
}

@Composable
fun CurriculumVitaeJobSection(job: Job) {
    MaterialTheme {
        Text(job.title, fontWeight = FontWeight.Bold, fontSize = 16.sp)
        Text(job.description, fontSize = 13.sp)
        Text(job.location, fontSize = 13.sp)
        Text("${job.dates.first} - ${job.dates.second}", fontSize = 13.sp)
    }
}

@Composable
fun CurriculumVitaeEducationSection(education: Education) {
    MaterialTheme {
        Text(education.title, fontWeight = FontWeight.Bold, fontSize = 16.sp)
        Text(education.description, fontSize = 13.sp)
        Text(education.location, fontSize = 13.sp)
        Text("${education.dates.first} - ${education.dates.second}", fontSize = 13.sp)
    }
}

@Composable
fun CurriculumVitaeSkillSection(skill: Skill) {
    MaterialTheme {
        Text("-${skill.title}")
    }
}
