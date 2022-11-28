package io.github.landrynorris.serpapi

import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.serialization.json.JsonObject

const val BACKEND = "https://serpapi.com"
const val SERP_API_VERSION = "2.0.3"

abstract class SerpApiSearch(val params: Map<String, String>,
                             val apiKey: String = "", val engine: String) {

    private suspend inline fun <reified T> query(path: String, format: String = "",
                                                 includeParams: Boolean = true): T {
        return client.get(ensureSlash(BACKEND, path)) {
            url {
                if(includeParams) appendParams(params)

                //inform the API of the current language
                parameters.append("source", "kotlin")
                parameters.append("engine", engine)
                if(format.isNotEmpty()) parameters.append("output", format)
            }

            timeout {
                connectTimeoutMillis = 6000
            }

            contentType(ContentType.Application.Json)
        }.body()
    }

    suspend fun getJson() = query<JsonObject>("/search", "json")

    suspend fun getAccountJson() = query<JsonObject>("/account", includeParams = false)

    private fun ensureSlash(part1: String, part2: String): String =
        part1 + '/' + part2.trimStart('/')
}
