package platform_expectations

import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.engine.android.Android
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

actual val appCoroutineContext: CoroutineContext = Dispatchers.Main
actual val httpClientEngineFactory: HttpClientEngineFactory<HttpClientEngineConfig> = Android
