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

@Composable
fun ScoreScreen(userScore: Int) {
    Card {
        Column(
            Modifier.then(if (userScore >= 10) Modifier.background(Color.Green) else Modifier.background(Color.Red)),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text("Score", fontWeight = FontWeight.Bold, fontSize = 22.sp)
            Text("$userScore/20")
            Button(onClick = {}) { Text("recommencer") }
        }
    }
}
