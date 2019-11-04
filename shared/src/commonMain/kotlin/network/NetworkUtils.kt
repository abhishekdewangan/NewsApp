package network

import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.features.defaultRequest
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.features.logging.DEFAULT
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logger
import io.ktor.client.features.logging.Logging
import io.ktor.http.URLProtocol
import kotlinx.serialization.json.Json


class NetworkUtils(httpClientEngine: HttpClientEngine)  {
    val httpClient: HttpClient = HttpClient(httpClientEngine) {
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.HEADERS
        }

        install(JsonFeature) {
            serializer = KotlinxSerializer(Json.nonstrict)
        }

        defaultRequest {
            url {
                protocol = URLProtocol.HTTPS
                host = "newsapi.org"
                parameters.append("apiKey", "3cf3a461818d4c628833f46e9e11ef45")
            }
        }
    }
}