package components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.RadioButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import network.data.Question

@Composable
fun QuestionScreen(questions: List<Question>) {
    var questionProgress by remember { mutableStateOf(0) }
    var selectedButton by remember { mutableStateOf(0) }
    var correctAnswer by remember { mutableStateOf(0) }
    Column(
        modifier = Modifier.fillMaxWidth().fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Card(backgroundColor = Color.Blue) {
            Text(questions[questionProgress].label)
        }
        Column(
            Modifier.selectableGroup(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            questions[questionProgress].answers.forEach { answer ->
                Row(
                    Modifier.selectable(
                        selected = (answer.id == selectedButton),
                        onClick = { selectedButton = answer.id },
                    ),
                ) {
                    RadioButton(
                        selected = (selectedButton == answer.id),
                        onClick = { selectedButton = answer.id },
                    )
                    Text(answer.label)
                }
            }
        }
        Button(
            onClick = {
                if (selectedButton == questions[questionProgress].correctAnswerId) { correctAnswer++ }
                if (questionProgress < questions.size - 1) { questionProgress++ } else { null }
            },
        ) {
            Text(text = (if (questionProgress < questions.size - 1) { "poursuivre" } else { "terminer" }))
        }
        Scaffold(
            bottomBar = {
                BottomAppBar(modifier = Modifier.height(10.dp).fillMaxWidth(), backgroundColor = Color.Transparent) {
                    /* Bottom app bar content */
                    LinearProgressIndicator(
                        modifier = Modifier.fillMaxWidth().height(10.dp),
                        progress = ((questionProgress + 1).toFloat() / questions.size),
                        color = Color.Red,
                    )
                }
            },
            content = {},
        )
    }
}
