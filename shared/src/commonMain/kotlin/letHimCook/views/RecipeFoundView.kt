package letHimCook.views

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.material.icons.filled.Create
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
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
import letHimCook.network.data.RecipeShort
import moe.tlaster.precompose.navigation.NavOptions
import moe.tlaster.precompose.navigation.Navigator

@Composable
fun recipeFoundView(
    api: SpoonacularAPI,
    navigator: Navigator,
    ingredientLists: String,
) {
    val (recipeList, setRecipeList) = remember { mutableStateOf<List<RecipeShort>>(emptyList()) }
    val (loading, setLoading) = remember { mutableStateOf(true) }

    LaunchedEffect(true) {
        setRecipeList(api.getRecipeIdListFromIngredient((ingredientLists)))
        setLoading(false)
    }

    if (loading) {
        loadingBox()
    } else {
        Scaffold(topBar = { recipeSearchAppBar(navigator) }) {
            Box(Modifier.padding(12.dp).fillMaxWidth(), contentAlignment = Alignment.Center) {
                Column {
                    if (recipeList.isEmpty()) {
                        Text("never let bro cook again \uD83D\uDC80")
                        Text("no recipes found")
                    } else {
                        Column(
                            Modifier.verticalScroll(
                                rememberScrollState(),
                            ).padding(8.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            Text("recipes", fontWeight = FontWeight.Bold, fontSize = 30.sp)
                            recipeList.forEach { recipe -> recipeShortCard(recipe, navigator) }
                        }
                    }
                }
            }
        }
    }
}

enum class CardType {
    USED,
    UNUSED,
    MISSED,
}

@Composable
fun ingredientsCard(
    ingredients: List<Ingredient>,
    cardtype: CardType,
) {
    Box(
        Modifier.padding(4.dp)
            .background(
                Brush.linearGradient(
                    resolveColor(cardtype),
                ),
                RoundedCornerShape(15),
            )
            .clip(RoundedCornerShape(15.dp)).fillMaxSize(),
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            when (cardtype) {
                CardType.USED -> Text("used ingredients : ", textAlign = TextAlign.Center)
                CardType.MISSED -> Text("missing ingredients : ", textAlign = TextAlign.Center)
                CardType.UNUSED -> Text("unusued Ingredients : ", textAlign = TextAlign.Center)
            }
            ingredients.forEach { ingredient: Ingredient ->
                Text("- ${resolveEmojiFromIngredientName(ingredient.name)}${ingredient.name}", textAlign = TextAlign.Center)
            }
        }
    }
}

fun resolveColor(cardtype: CardType): List<Color> {
    return when (cardtype) {
        CardType.USED ->
            listOf(
                Color(168, 255, 120),
                Color(120, 255, 214),
            )
        CardType.UNUSED ->
            listOf(
                Color(216, 180, 158),
                Color(213, 91, 16),
            )
        CardType.MISSED ->
            listOf(
                Color(225, 151, 139),
                Color(208, 41, 16),
            )
    }
}

@Composable
fun recipeShortCard(
    recipe: RecipeShort,
    navigator: Navigator,
) {
    Card(
        Modifier.padding(8.dp).clickable {
            navigator.navigate("/recipe/${recipe.id}", NavOptions(launchSingleTop = true))
        }.clip(RoundedCornerShape(20.dp)),
        shape = RoundedCornerShape(20.dp),
        backgroundColor = Color(82, 183, 136),
        border = BorderStroke(2.dp, Color(18, 84, 24)),
        elevation = 8.dp,
    ) {
        Column(Modifier.padding(10.dp).fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Column(Modifier.padding(14.dp).width(400.dp).height(230.dp).clip(RoundedCornerShape(25.dp))) {
                KamelImage(
                    resource = asyncPainterResource(recipe.image!!),
                    contentDescription = "recipe image",
                    onLoading = {
                            progress ->
                        CircularProgressIndicator(progress, color = Color(82, 183, 136))
                    },
                )
            }
            Column {
                Card(Modifier.background(Color.White).border(0.dp, Color.Transparent, RoundedCornerShape(25.dp)).fillMaxWidth()) {
                    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            recipe.title,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                        )
                        if (!recipe.usedIngredients.isNullOrEmpty()) {
                            ingredientsCard(recipe.usedIngredients, CardType.USED)
                        }
                        if (!recipe.missedIngredients.isNullOrEmpty()) {
                            ingredientsCard(recipe.missedIngredients, CardType.MISSED)
                        }
                        if (!recipe.unusedIngredients.isNullOrEmpty()) {
                            ingredientsCard(recipe.unusedIngredients, CardType.UNUSED)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun recipeSearchAppBar(navigator: Navigator) {
    TopAppBar(backgroundColor = Color(82, 183, 136), elevation = 8.dp) {
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = null,
            modifier =
                Modifier
                    .size(30.dp)
                    .clip(RoundedCornerShape(100.dp))
                    .clickable { navigator.goBack() },
        )
        Icon(
            imageVector = Icons.Filled.Create,
            contentDescription = null,
            modifier =
                Modifier.size(30.dp).clip(
                    RoundedCornerShape(100.dp),
                ).clickable { navigator.navigate("/recipe/random") },
        )
    }
}
