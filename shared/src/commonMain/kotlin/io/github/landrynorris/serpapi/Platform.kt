package io.github.landrynorris.serpapi

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform