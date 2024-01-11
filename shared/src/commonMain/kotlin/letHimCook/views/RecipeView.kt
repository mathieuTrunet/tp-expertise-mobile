package letHimCook.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import letHimCook.network.SpoonacularAPI
import letHimCook.network.data.Recipe
import moe.tlaster.precompose.navigation.Navigator

@Composable
fun recipeView(
    navigator: Navigator,
    api: SpoonacularAPI,
    recipeId: Int?,
) {
    val (recipe, setRecipe) = remember { mutableStateOf<Recipe?>(null) }
    val (loading, setLoading) = remember { mutableStateOf(true) }

    LaunchedEffect(true) {
        setRecipe(api.getRandomRecipe())
        setLoading(false)
    }

    if (loading) {
        Text("yee")
    } else {
        if (recipe != null) {
            Card(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
            ) {
                Column(
                    modifier =
                        Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                ) {
                    // Display Recipe Image

                    // Display Recipe Title
                    Text(
                        text = recipe.title,
                        style = MaterialTheme.typography.h5,
                        fontWeight = FontWeight.Bold,
                        modifier =
                            Modifier
                                .padding(top = 8.dp)
                                .fillMaxWidth(),
                    )

                    // Display Recipe Details
                    Row(
                        modifier =
                            Modifier
                                .fillMaxWidth()
                                .padding(top = 8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Text(
                            text = "Ready in ${recipe.readyInMinutes} mins",
                            style = MaterialTheme.typography.body2,
                            color = Color.Red,
                        )
                        Text(
                            text = "Servings: ${recipe.servings}",
                            style = MaterialTheme.typography.body2,
                            color = Color.Red,
                        )
                    }

                    // Display Ingredients
                    recipe.extendedIngredients.forEach { ingredient ->
                        Text(
                            text = "${ingredient.amount} ${ingredient.unit} ${ingredient.name}",
                            style = MaterialTheme.typography.body2,
                            modifier = Modifier.padding(top = 4.dp),
                        )
                    }
                }
            }
        }
    }
}
