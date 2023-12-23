package components

import Ingredient
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun IngredientBoard(ingredients: List<Ingredient>) {
    val columnSize = 5
    val rows: List<List<Ingredient>> = ingredients.chunked(columnSize)

    Card(modifier = Modifier.border(2.dp, Color.Black)) {
        Column {
            rows.forEach { rowIngredients ->
                Row {
                    rowIngredients.forEach { ingredient ->
                        Box(Modifier.weight(1f)) { IngredientButton(ingredient.emoji) }
                    }
                }
            }
        }
    }
}

@Composable
fun IngredientButton(ingredientEmoji: String) { Button(onClick = {}) { Text(ingredientEmoji) } }
