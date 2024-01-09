package network

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import network.data.Recipe

class FoodRepository(apiKey: String) {
    private val foodAPI = SpoonacularAPI(apiKey)
    private val coroutine = CoroutineScope(Dispatchers.IO)


}
