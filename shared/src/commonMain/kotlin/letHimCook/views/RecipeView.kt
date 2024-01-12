package letHimCook.views

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import letHimCook.components.loadingBox
import letHimCook.constants.resolveEmojiFromIngredientName
import letHimCook.network.SpoonacularAPI
import letHimCook.network.data.Ingredient
import letHimCook.network.data.Recipe
import letHimCook.network.data.RecipeShort
import letHimCook.network.data.Step
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
        setRecipe(api.getRecipeById(recipeId!!))
        setLoading(false)
    }

    if (loading) loadingBox()

    if (recipe != null) {
        Scaffold(topBar = { recipeViewAppBar() }) {
            Box(Modifier.padding(12.dp).fillMaxWidth(), contentAlignment = Alignment.Center) {
                Column {
                    Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                        Text(
                            recipe.title,
                            fontWeight = FontWeight.Bold,
                            fontStyle = FontStyle.Italic,
                            fontSize = 25.sp,
                            textAlign = TextAlign.Center,
                        )
                    }
                    Card(
                        // backgroundColor = Color(82, 183, 136),
                        elevation = 8.dp,
                        shape = RoundedCornerShape(20.dp),
                        border = BorderStroke(2.dp, Color(18, 84, 24)),
                    ) {
                        Box(
                            Modifier.background(
                                Brush.linearGradient(
                                    listOf(
                                        Color(168, 255, 120),
                                        Color(120, 255, 214),
                                    ),
                                ),
                            ),
                        ) {
                            Column(
                                Modifier.verticalScroll(rememberScrollState()).padding(12.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                            ) {
                                mainInformationCard(recipe)
                                ingredientsCard(recipe.extendedIngredients)
                                instructionsCard(recipe.analyzedInstructions.first().steps)
                                similarRecipeCard(recipe.id, api, navigator)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun similarRecipeCard(
    recipeId: Int,
    api: SpoonacularAPI,
    navigator: Navigator,
) {
    val (similarRecipeList, setSimilarRecipeList) = remember { mutableStateOf<List<RecipeShort>>(emptyList()) }
    val (loading, setLoading) = remember { mutableStateOf(true) }

    LaunchedEffect(true) {
        setSimilarRecipeList(api.getSimilarRecipeList(recipeId))
        setLoading(false)
    }

    if (loading) loadingBox()

    if (similarRecipeList.isNotEmpty()) {
        Column {
            Card(Modifier.padding(8.dp), shape = RoundedCornerShape(20.dp), backgroundColor = Color.White, elevation = 8.dp) {
                Column(Modifier.padding(8.dp).fillMaxWidth().padding(start = 8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                    Box(contentAlignment = Alignment.Center) {
                        Text("similars recipes", fontWeight = FontWeight.Bold, fontSize = 15.sp)
                    }
                }
            }
            Column {
                Column(Modifier.padding(8.dp).fillMaxWidth().padding(start = 8.dp)) {
                    similarRecipeList.forEach { similarRecipe: RecipeShort ->
                        Box(
                            Modifier
                                .padding(8.dp)
                                .background(Color(82, 183, 136), RoundedCornerShape(40))
                                .border(2.dp, Color(18, 84, 24), RoundedCornerShape(40))
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(60.dp))
                                .clickable { navigator.navigate("/") },
                            contentAlignment = Alignment.Center,
                        ) {
                            Box(
                                Modifier.padding(6.dp),
                            ) {
                                Text(
                                    similarRecipe.title,
                                    fontStyle = FontStyle.Italic,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Center,
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun instructionsCard(instructions: List<Step>) {
    Card(Modifier.padding(8.dp), shape = RoundedCornerShape(20.dp), backgroundColor = Color.White, elevation = 8.dp) {
        Column(Modifier.padding(8.dp).fillMaxWidth().padding(start = 8.dp)) {
            Box(contentAlignment = Alignment.Center) { Text("Instructions", fontWeight = FontWeight.Bold, fontSize = 15.sp) }
            instructions.forEach { step: Step ->
                Text("- step ${step.number}", fontWeight = FontWeight.Bold)
                Box(Modifier.padding(start = 12.dp)) { Text(step.step) }
            }
        }
    }
}

@Composable
fun ingredientsCard(ingredients: List<Ingredient>) {
    Card(Modifier.padding(8.dp), shape = RoundedCornerShape(20.dp), backgroundColor = Color.White, elevation = 8.dp) {
        Column(Modifier.padding(8.dp).fillMaxWidth().padding(start = 8.dp)) {
            Box(contentAlignment = Alignment.Center) { Text("Ingredients", fontWeight = FontWeight.Bold, fontSize = 15.sp) }
            ingredients.forEach { ingredient: Ingredient ->
                Text("- ${ingredient.amount} ${ingredient.unit} of ${resolveEmojiFromIngredientName(ingredient.name)} ${ingredient.name}")
            }
        }
    }
}

@Composable
fun mainInformationCard(recipe: Recipe) {
    Card(Modifier.padding(8.dp), shape = RoundedCornerShape(20.dp), backgroundColor = Color.White, elevation = 8.dp) {
        Column(Modifier.padding(8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Column(Modifier.width(400.dp).height(210.dp).clip(RoundedCornerShape(25.dp))) {
                KamelImage(
                    resource = asyncPainterResource(recipe.image),
                    contentDescription = "recipe image",
                    onLoading = {
                            progress ->
                        CircularProgressIndicator(progress, color = Color(82, 183, 136))
                    },
                )
            }
            Column {
                Text(recipe.title, fontWeight = FontWeight.Bold, fontStyle = FontStyle.Italic)
                Text("\uD83D\uDC68\u200D\uD83D\uDC68\u200D\uD83D\uDC66\u200D\uD83D\uDC66 for ${recipe.servings} peoples")
                Text(
                    "⏲\uFE0F estimated cooking time : ${recipe.readyInMinutes} minutes",
                )
                if (recipe.vegan) {
                    dietBox("\uD83E\uDD57✨ vegan")
                } else if (recipe.vegetarian) {
                    dietBox("\uD83E\uDD57 vegetarian")
                }
            }
        }
    }
}

@Composable
fun dietBox(text: String) {
    Box(
        Modifier.padding(4.dp)
            .background(
                Color(82, 183, 136),
                RoundedCornerShape(40),
            )
            .border(0.dp, Color.Transparent, RoundedCornerShape(40))
            .clip(RoundedCornerShape(60.dp)),
    ) {
        Text(text)
    }
}

@Composable
fun recipeViewAppBar() {
    TopAppBar(backgroundColor = Color(82, 183, 136), elevation = 8.dp) {
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = null,
            modifier =
                Modifier
                    .size(30.dp)
                    .clip(RoundedCornerShape(100.dp))
                    .clickable {},
        )
    }
}
