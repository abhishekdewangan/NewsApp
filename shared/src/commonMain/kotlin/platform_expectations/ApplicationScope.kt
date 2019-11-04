package platform_expectations

import kotlinx.coroutines.CoroutineDispatcher
import kotlin.coroutines.CoroutineContext

expect val appCoroutineContext: CoroutineContext

expect val ioDispatcher: CoroutineDispatcher

expect val mainDispatcher: CoroutineDispatcher
