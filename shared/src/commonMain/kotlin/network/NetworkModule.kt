package network

import io.ktor.client.HttpClient
import org.kodein.di.Kodein
import org.kodein.di.erased.bind
import org.kodein.di.erased.singleton
import platform_expectations.httpClientEngineFactory

class NetworkModule {
    companion object {
        val networkModule = Kodein.Module("NetworkModule") {
            bind<HttpClient>() with singleton { NetworkUtils(httpClientEngineFactory).httpClient }
        }
    }
}