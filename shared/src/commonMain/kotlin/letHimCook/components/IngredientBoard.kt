package letHimCook.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import letHimCook.constants.Ingredient

@Composable
fun ingredientBoard(
    ingredientsDisplayed: List<Ingredient>,
    selectedIngredients: List<Ingredient>,
    onIngredientChanged: (Ingredient, Boolean) -> Unit,
) {
    val columnSize = 5

    val ingredientsRows = ingredientsDisplayed.chunked(columnSize)

    Card(backgroundColor = Color.White, elevation = 10.dp, shape = RoundedCornerShape(10)) {
        Column(Modifier.verticalScroll(rememberScrollState()).padding(5.dp)) {
            ingredientsRows.forEach { ingredientsRow ->
                Row {
                    ingredientsRow.forEach { ingredient ->
                        Box(Modifier.weight(1f), contentAlignment = Alignment.Center) {
                            ingredientButton(
                                ingredient,
                                selectedIngredients.contains(ingredient),
                            ) { isSelected ->
                                onIngredientChanged(ingredient, isSelected)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ingredientButton(
    ingredient: Ingredient,
    isSelected: Boolean,
    onSelected: (Boolean) -> Unit,
) {
    Box(
        Modifier
            .padding(4.dp)
            .background(Color.Transparent, RoundedCornerShape(40))
            .border(2.dp, Color(18, 84, 24), RoundedCornerShape(40))
            .clip(RoundedCornerShape(60.dp)).clickable {
                onSelected(!isSelected)
            }
            .then(
                if (isSelected) {
                    Modifier.background(
                        Brush.linearGradient(
                            listOf(
                                Color(168, 255, 120),
                                Color(120, 255, 214),
                            ),
                        ),
                        RoundedCornerShape(40),
                    )
                } else {
                    Modifier.background(Color.Transparent)
                },
            ).padding(16.dp),
    ) {
        Text(ingredient.emoji)
    }
}
