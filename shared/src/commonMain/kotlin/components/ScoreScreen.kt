package components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import moe.tlaster.precompose.navigation.Navigator

@Composable
fun ScoreScreen(navigator: Navigator, score: String) {
    val serealizedScore = serealizeScore(score)

    val seralizedNumberOfQuestions = serealizeNumberOfQuestion(score)

    Card {
        Column(
            Modifier.then(if (serealizedScore >= (seralizedNumberOfQuestions / 2)) Modifier.background(Color.Green) else Modifier.background(Color.Red)),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text("Score", fontWeight = FontWeight.Bold, fontSize = 22.sp)
            Text("$serealizedScore / $seralizedNumberOfQuestions")
            Button(onClick = { navigator.navigate("/quiz") }) { Text("recommencer") }
        }
    }
}

val serealizeScore: (String) -> Int = { a -> a.split(".")[0].toInt() }

val serealizeNumberOfQuestion: (String) -> Int = { a -> a.split(".")[1].toInt() }
