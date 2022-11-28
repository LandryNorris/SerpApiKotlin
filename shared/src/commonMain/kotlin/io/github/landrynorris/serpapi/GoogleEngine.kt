package io.github.landrynorris.serpapi

class GoogleEngine(params: Map<String, String>, apiKey: String = ""):
    SerpApiSearch(params, apiKey, "google")
