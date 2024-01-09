package network.data

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import network.SpoonacularAPI

class FoodRepository(apiKey: String) {
    private val foodAPI = SpoonacularAPI(apiKey)
    private val coroutine = CoroutineScope(Dispatchers.IO)
}
