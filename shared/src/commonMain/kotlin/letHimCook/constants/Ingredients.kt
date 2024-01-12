package letHimCook.constants

data class DisplayIngredient(val emoji: String, val name: String)

val resolveEmojiFromIngredientName: (String) -> String = { ingredientName ->
    ingredients.find { ingredient -> ingredientName.contains(ingredient.name) }?.emoji ?: ""
}

val getSelectedIngredientsAsString: (List<DisplayIngredient>) -> String = { list -> list.joinToString(", ") { it.emoji } }

val ingredients =
    listOf(
        DisplayIngredient("🥑", "avocado"),
        DisplayIngredient("🍌", "banana"),
        DisplayIngredient("🥩", "beef"),
        DisplayIngredient("🍞", "bread"),
        DisplayIngredient("🥦", "broccoli"),
        DisplayIngredient("🍉", "watermelon"),
        DisplayIngredient("🍋", "lemon"),
        DisplayIngredient("🍗", "chicken"),
        DisplayIngredient("🍍", "pineapple"),
        DisplayIngredient("🍎", "apple"),
        DisplayIngredient("🍅", "tomato"),
        DisplayIngredient("🥝", "kiwi"),
        DisplayIngredient("🥔", "potato"),
        DisplayIngredient("🥕", "carrot"),
        DisplayIngredient("🍄", "mushroom"),
        DisplayIngredient("🍇", "grape"),
        DisplayIngredient("🍓", "strawberry"),
        DisplayIngredient("🧀", "cheese"),
        DisplayIngredient("🥓", "bacon"),
        DisplayIngredient("🍑", "peach"),
        DisplayIngredient("🌽", "corn"),
        DisplayIngredient("🥚", "egg"),
        DisplayIngredient("🍠", "sweet potato"),
        DisplayIngredient("🍈", "melon"),
        DisplayIngredient("🍆", "eggplant"),
        DisplayIngredient("🍊", "orange"),
        DisplayIngredient("🥥", "coconut"),
        DisplayIngredient("🌰", "chestnut"),
        DisplayIngredient("🍯", "honey"),
        DisplayIngredient("🥖", "baguette"),
        DisplayIngredient("🍏", "green apple"),
        DisplayIngredient("🍒", "cherry"),
        DisplayIngredient("🍤", "shrimp"),
        DisplayIngredient("🍖", "pork"),
        DisplayIngredient("🌶️", "chili pepper"),
        DisplayIngredient("🍚", "rice"),
        DisplayIngredient("🥜", "peanut"),
        DisplayIngredient("🧅", "onion"),
        DisplayIngredient("🥭", "mango"),
        DisplayIngredient("🥒", "cucumber"),
    )
