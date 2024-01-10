package letHimCook.constants

data class Ingredient(val emoji: String, val name: String)

val resolveEmojiFromIngredientName: (String) -> String = { ingredientName ->
    ingredients.find { ingredient -> ingredient.name === ingredientName }?.emoji ?: ""
}

val getSelectedIngredientsAsString: (List<Ingredient>) -> String = { list -> list.joinToString(", ") { it.emoji } }

val ingredients =
    listOf(
        Ingredient("🥑", "avocado"),
        Ingredient("🍌", "banana"),
        Ingredient("🥩", "beef"),
        Ingredient("🍞", "bread"),
        Ingredient("🥦", "broccoli"),
        Ingredient("🍉", "watermelon"),
        Ingredient("🍋", "lemon"),
        Ingredient("🍗", "chicken"),
        Ingredient("🍍", "pineapple"),
        Ingredient("🍎", "apple"),
        Ingredient("🍅", "tomato"),
        Ingredient("🥝", "kiwi"),
        Ingredient("🥔", "potato"),
        Ingredient("🥕", "carrot"),
        Ingredient("🍄", "mushroom"),
        Ingredient("🍇", "grape"),
        Ingredient("🍓", "strawberry"),
        Ingredient("🧀", "cheese"),
        Ingredient("🥓", "bacon"),
        Ingredient("🍑", "peach"),
        Ingredient("🌽", "corn"),
        Ingredient("🥚", "egg"),
        Ingredient("🍠", "sweet potato"),
        Ingredient("🍈", "melon"),
        Ingredient("🍆", "eggplant"),
        Ingredient("🍊", "orange"),
        Ingredient("🥥", "coconut"),
        Ingredient("🌰", "chestnut"),
        Ingredient("🍯", "honey"),
        Ingredient("🥖", "baguette"),
        Ingredient("🍏", "green apple"),
        Ingredient("🍒", "cherry"),
        Ingredient("🍤", "shrimp"),
        Ingredient("🍖", "pork"),
        Ingredient("🌶️", "chili pepper"),
        Ingredient("🍚", "rice"),
        Ingredient("🥜", "peanut"),
        Ingredient("🧅", "onion"),
        Ingredient("🥭", "mango"),
        Ingredient("🥒", "cucumber"),
    )
