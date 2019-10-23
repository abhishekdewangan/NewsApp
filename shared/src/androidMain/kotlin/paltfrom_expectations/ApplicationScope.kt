package paltfrom_expectations

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

actual val appCoroutineContext: CoroutineContext = Dispatchers.Main
