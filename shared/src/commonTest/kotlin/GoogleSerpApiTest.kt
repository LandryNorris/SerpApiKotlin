import io.github.landrynorris.serpapi.GoogleEngine
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class GoogleSerpApiTest {

    @Test
    fun testSearchJson() {
        val params = mapOf("q" to "Coffee", "location" to "Austin, Texas")
        //API_KEY is defined in Secrets.kt in the same directory
        val engine = GoogleEngine(params, apiKey = API_KEY)
        val result = runBlocking { engine.getJson() }

        assertTrue(result.isNotEmpty())
    }

    @Test
    fun testSearch() {
        val params = mapOf("q" to "Coffee", "location" to "Austin, Texas")
        //API_KEY is defined in Secrets.kt in the same directory
        val engine = GoogleEngine(params, apiKey = API_KEY)
        val result = runBlocking { engine.getSearchResults() }

        assertTrue(result.organicResults.isNotEmpty())
    }

    @Test
    fun testNoResults() {
        val params = mapOf("q" to "absgdgjekenfbgt28173foeh", "location" to "Austin, Texas")
        //API_KEY is defined in Secrets.kt in the same directory
        val engine = GoogleEngine(params, apiKey = API_KEY)
        val result = runBlocking { engine.getSearchResults() }

        assertTrue(result.organicResults.isEmpty())
        assertEquals("Fully empty", result.searchInformation.organicResultsState)
    }

    @Test
    fun testGetAccount() {
        //API_KEY is defined in Secrets.kt in the same directory
        val engine = GoogleEngine(mapOf(), apiKey = API_KEY)
        val account = runBlocking { engine.getAccount() }
        assertEquals(account.email, "landry.norris@live.com")
    }
}