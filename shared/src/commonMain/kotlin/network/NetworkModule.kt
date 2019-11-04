package network

import io.ktor.client.HttpClient
import org.kodein.di.Kodein
import org.kodein.di.erased.bind
import org.kodein.di.erased.instance
import org.kodein.di.erased.singleton

class NetworkModule {
  companion object {
    val networkModule = Kodein.Module("NetworkModule") {
      bind<HttpClient>() with singleton { NetworkUtils(instance()).httpClient }
    }
  }
}