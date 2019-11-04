package network

import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.features.logging.DEFAULT
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logger
import io.ktor.client.features.logging.Logging


class NetworkUtils(httpClientEngine: HttpClientEngine)  {
    val httpClient: HttpClient = HttpClient(httpClientEngine) {
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.HEADERS
        }

        install(JsonFeature) {
            serializer = KotlinxSerializer()
        }
    }
}