import io.github.landrynorris.serpapi.GoogleEngine
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class GoogleSerpApiTest {

    @Test
    fun testSearch() {
        val params = mapOf("q" to "Coffee", "location" to "Austin, Texas")
        //API_KEY is defined in Secrets.kt in the same directory
        val engine = GoogleEngine(params, apiKey = API_KEY)
        val result = runBlocking { engine.getJson() }

        assertTrue(result.containsKey("organic_results"))
    }

    @Test
    fun testGetAccount() {
        //API_KEY is defined in Secrets.kt in the same directory
        val engine = GoogleEngine(mapOf(), apiKey = API_KEY)
        val account = runBlocking { engine.getAccount() }
        assertEquals(account.email, "landry.norris@live.com")
    }
}