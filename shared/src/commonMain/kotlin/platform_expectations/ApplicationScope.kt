package platform_expectations

import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.engine.HttpClientEngineFactory
import kotlinx.coroutines.CoroutineDispatcher
import kotlin.coroutines.CoroutineContext

expect val appCoroutineContext: CoroutineContext

expect val httpClientEngineFactory: HttpClientEngineFactory<HttpClientEngineConfig>

expect val ioDispatcher: CoroutineDispatcher

expect val mainDispatcher: CoroutineDispatcher
