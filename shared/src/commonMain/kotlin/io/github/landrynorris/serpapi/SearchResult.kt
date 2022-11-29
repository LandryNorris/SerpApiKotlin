package io.github.landrynorris.serpapi

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchResult(
    @SerialName("organic_results") val organicResults: List<OrganicResult> = listOf(),
    @SerialName("search_information") val searchInformation: SearchInformation
)

@Serializable
data class OrganicResult(
    val position: Int = -1,
    val title: String,
    val link: String,
    @SerialName("displayed_link") val displayedLink: String,
    val thumbnail: String? = null,
    val snippet: String = "",
    @SerialName("snippet_highlighted_words") val snippetHighlightedWords: List<String> = listOf(),
    val sitelinks: SiteLinks = SiteLinks(),
    @SerialName("related_pages_link") val relatedPages: String? = null,
    @SerialName("rich_snippet") val richSnippet: RichSnippet? = null,
    @SerialName("about_this_result") val aboutResult: AboutResult? = null,
    @SerialName("about_page_link") val aboutPageLink: String? = null,
    @SerialName("about_page_serpapi_link") val aboutPageSerpLink: String? = null,
    @SerialName("cached_page_link") val cachedPageLink: String? = null
)

@Serializable
data class RichSnippet(val top: Snippet? = null, val bottom: Snippet? = null)

@Serializable
data class Snippet(
    val extensions: List<String> = listOf()
)

@Serializable
data class AboutResult(
    val source: Source? = null,
    val keywords: List<String> = listOf(),
    val languages: List<String> = listOf(),
    val regions: List<String> = listOf()
)

@Serializable
data class Source(
    val description: String,
    @SerialName("source_info_link") val sourceInfoLink: String,
    val security: String,
    val icon: String? = null
)

@Serializable
data class SiteLinks(val inline: List<SiteLink> = listOf(), val expanded: List<SiteLink> = listOf())

@Serializable
data class SiteLink(val title: String, val link: String, val snippet: String = "")

@Serializable
data class SearchInformation(
    @SerialName("organic_results_state") val organicResultsState: String,
    @SerialName("query_displayed") val queryDisplayed: String? = null,
    @SerialName("total_results") val totalResults: Long = 0,
    @SerialName("time_taken_displayed") val timeTaken: Double = 0.0
)
