package letHimCook.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import getPlatformName
import letHimCook.components.ingredientBoard
import letHimCook.components.recipeSearchButton
import letHimCook.constants.DisplayIngredient
import letHimCook.constants.ingredients
import moe.tlaster.precompose.navigation.Navigator
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

val isPlatformDesktop: () -> Boolean = { getPlatformName() === "Desktop" }

val getFormattedIngredientList: (List<DisplayIngredient>) -> String = { ingredients ->
    ingredients.joinToString(",") { it.name }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun ingredientSelectionView(navigator: Navigator) {
    val (showHelp, setShowHelp) = remember { mutableStateOf(false) }

    var selectedIngredients by remember { mutableStateOf<List<DisplayIngredient>>(emptyList()) }
    val isAtLeastOneIngredientSelected = selectedIngredients.isNotEmpty()

    Row {
        Image(
            painterResource("kitchen-background.jpg"),
            contentDescription = null,
        )
    }

    Row {
        Box(Modifier.weight(2f)) {}
        Column(Modifier.weight(4f), horizontalAlignment = Alignment.CenterHorizontally) {
            Column(Modifier.weight(1.3f)) { }
            Column(Modifier.weight(2f)) {
                Card(elevation = 10.dp, shape = RoundedCornerShape(30)) {
                    Box(Modifier.padding(5.dp)) {
                        Text("let him cook 👨‍🍳", fontSize = 25.sp)
                    }
                }
            }
            Column(Modifier.weight(10f).border(2.dp, Color.Green)) {}
        }
        Box(Modifier.weight(2f)) {}
    }

    Column {
        Row(Modifier.weight(1f)) {}
        Row(
            Modifier.weight(
                if (isPlatformDesktop()) {
                    2.1f
                } else {
                    2.8f
                },
            ),
        ) {
            Surface(
                color = Color(82, 183, 136),
                shape = RoundedCornerShape(topStart = 50.dp, topEnd = 50.dp),
            ) {
                Row {
                    Column(modifier = Modifier.weight(2f)) {}
                    Column(
                        modifier = Modifier.weight(40f),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Box(Modifier.weight(1f)) {}
                        Box(Modifier.weight(6f)) {
                            ingredientBoard(
                                ingredientsDisplayed = ingredients,
                                selectedIngredients = selectedIngredients,
                                onIngredientChanged = { ingredient, isSelected ->
                                    if (isSelected) {
                                        selectedIngredients += ingredient
                                    } else {
                                        selectedIngredients -= ingredient
                                    }
                                },
                            )
                        }
                        Box(Modifier.weight(0.7f)) {}
                        Box(
                            Modifier.weight(2f),
                        ) { recipeSearchButton(isAtLeastOneIngredientSelected, navigator, getFormattedIngredientList(selectedIngredients)) }
                    }
                    Column(modifier = Modifier.weight(2f)) {}
                }
            }
        }
    }

    Row {
        Column(Modifier.weight(95f)) {}
        Column(Modifier.weight(20f), horizontalAlignment = Alignment.CenterHorizontally) {
            Box(Modifier.weight(5f)) {}
            Box(Modifier.weight(20f)) {
                helperFab { setShowHelp(true) }
            }
            Box(Modifier.weight(95f)) {}
        }
        Column(Modifier.weight(5f)) {}
    }

    if (showHelp) {
        help(setShowHelp)
    }
}

@Composable
fun helperFab(onClick: (Boolean) -> Unit) {
    FloatingActionButton(
        onClick = { onClick(true) },
        shape = RoundedCornerShape(40),
        backgroundColor = Color(82, 183, 136),
        contentColor = Color(18, 84, 24),
    ) { Icon(Icons.Filled.Info, "How to do the cookin ?") }
}

@Composable
fun help(showHelp: (Boolean) -> Unit) {
    Box(Modifier.background(Color.Black.copy(alpha = 0.6f)).fillMaxSize(), contentAlignment = Alignment.Center) {
        Card(Modifier.size(525.dp)) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Box(Modifier.weight(0.5f), contentAlignment = Alignment.Center) {
                    Text("How to do the cookin ? \uD83D\uDC68\u200D\uD83C\uDF73", fontWeight = FontWeight.Bold)
                }
                Box(Modifier.weight(1.5f)) {
                    Column {
                        Text(
                            "- Select the ingredients you want in your cookin on the first page, when done , click on the do the cookin button",
                            Modifier.padding(5.dp),
                        )
                        Text(
                            "- you land on the cookin found with ur recipes, some may not have all of what you choosed, and some may needs more ingredients",
                            Modifier.padding(5.dp),
                        )
                        Text(
                            "- click on a cookin to see all the ingredients needed, for how many people it is, is it vegetarian or vegan, and the cookin instructions",
                            Modifier.padding(5.dp),
                        )
                        Text(
                            "- if you don't like the cookin, you can choose in a list of similar cookin at the bottom of thr page",
                            Modifier.padding(5.dp),
                        )
                        Text(
                            "- if you want to let the bro cook, click on the upper second button, on the second page, and let the bro do the cookin",
                            Modifier.padding(5.dp),
                        )
                    }
                }

                Box(
                    Modifier.weight(0.5f),
                    contentAlignment = Alignment.Center,
                ) {
                    Button(
                        onClick = {
                            showHelp(false)
                        },
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(82, 183, 136)),
                    ) { Text("I got it") }
                }
            }
        }
    }
}
