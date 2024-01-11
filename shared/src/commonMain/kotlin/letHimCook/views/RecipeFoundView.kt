package letHimCook.views

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import letHimCook.network.SpoonacularAPI
import letHimCook.network.data.Recipe
import moe.tlaster.precompose.navigation.Navigator

@Composable
fun recipeFoundView(
    api: SpoonacularAPI,
    navigator: Navigator,
) {
    val (recipe, setRecipe) = remember { mutableStateOf<Recipe?>(null) }
    val (loading, setLoading) = remember { mutableStateOf(true) }

    LaunchedEffect(true) {
        println(api.getRandomRecipe())
        setRecipe(api.getRandomRecipe())
        setLoading(false)
    }
    Column {
        Row(Modifier.weight(1f)) { }
        Row(Modifier.weight(1f)) {
            Row(Modifier.weight(1f)) { }
            Row(Modifier.weight(1f).border(1.dp, Color.Red)) {
                if (loading) {
                    Text("caharge")
                } else {
                    if (recipe != null) {
                        Text("yoo${recipe.id} ; ${recipe.title}")
                    } else {
                        Text("yapa")
                    }
                }
            }
            Row(Modifier.weight(1f)) { }
        }
        Row(Modifier.weight(1f)) { }
    }
}
