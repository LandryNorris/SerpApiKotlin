package io.github.landrynorris.serpapi

import io.ktor.http.*

fun URLBuilder.appendParams(params: Map<String, String>) {
    params.forEach {
        parameters.append(it.key, it.value)
    }
}
