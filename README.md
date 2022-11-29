SerpAPI Kotlin
==============

This Kotlin package enables to scrape and parse Google, Bing and Baidu search results 
using [SerpApi](https://serpapi.com). Feel free to fork this repository to add more backends.

This project is an implementation of SerpApi in pure Kotlin.
This code depends on kotlinx-serialization for efficient JSON processing.
The HTTP response are converted to JSON Object or to a model class.

An example is provided in the test.
@see shared/src/commonTest/kotlin/GoogleSerpApiTest.kt

[The full documentation is available here.](https://serpapi.com/search-api)

Quick Start
===========

Note: You need an account with SerpApi to obtain this key from: https://serpapi.com/dashboard

```kotlin
fun main() {
    val params = listOf("q" to "coffee", "location" to "Dallas, Texas")
    val engine = GoogleEngine(params, apiKey = YOUR_API_KEY)
    val searchResult = engine.getAccountJson() //for supported output
    val resultJson = engine.getJson() //for more information
}
```

This example runs a search about "coffee" using your secret api key.

The Serp API service (backend)

    searches on Google using the query: q = "coffee"
    parses the messy HTML responses
    return a standardized JSON response The class GoogleSearch
    Format the request to Serp API server
    Execute GET http request
    Parse JSON using kotlinx-serialization

Alternatively, you can search:

    Bing using BingSearch class (To be implemented)
    Baidu using BaiduSearch class (To be implemented)

See the playground to generate your code. https://serpapi.com/playground

Features left to implement
--------------------------

To reach parity with https://github.com/serpapi/google-search-results-java we need to implement:

1. Locations API
2. Search Archive API
3. HTML response
