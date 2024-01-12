package letHimCook.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import moe.tlaster.precompose.navigation.Navigator

@Composable
fun recipeSearchButton(
    isAtLeastOneIngredientSelected: Boolean,
    navigator: Navigator,
    ingredientList: String,
) {
    Box(
        Modifier
            .clip(RoundedCornerShape(20.dp))
            .clickable(isAtLeastOneIngredientSelected) { navigator.navigate("/recipe/search/$ingredientList") }.shadow(8.dp)
            .background(
                Brush.linearGradient(
                    getColors(isAtLeastOneIngredientSelected),
                ),
                RoundedCornerShape(40),
            )
            .border(2.dp, Color(18, 84, 24), RoundedCornerShape(40))
            .padding(14.dp),
    ) {
        Text("let's do the cookin")
    }
}

val getColors: (Boolean) -> List<Color> = { isAtLeastOneIngredientSelected ->
    if (isAtLeastOneIngredientSelected) {
        listOf(
            Color(168, 255, 120),
            Color(120, 255, 214),
        )
    } else {
        listOf(
            Color(176, 164, 164),
            Color(176, 164, 164),
        )
    }
}
