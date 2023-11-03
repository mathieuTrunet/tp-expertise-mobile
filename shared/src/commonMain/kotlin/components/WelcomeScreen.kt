package components
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun WelcomeScreen() {
    Card {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Quizz", fontWeight = FontWeight.Bold, fontSize = 22.sp)
            Text("un petit quizz ,pour se détendre, au calme...")
            Button(onClick = {}) { Text("commencer") }
        }
    }
}
