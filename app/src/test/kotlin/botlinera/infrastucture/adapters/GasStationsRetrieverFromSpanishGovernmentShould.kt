package botlinera.infrastucture.adapters

import botlinera.domain.fixtures.GasStationFixtures.Companion.gasStation
import botlinera.infrastructure.adapters.GasStationsRetrieverFromSpanishGovernment
import botlinera.infrastructure.utils.URLWrapper
import org.junit.Test
import org.mockito.Mockito.*
import kotlin.test.assertEquals


private const val EXPECTED_GAS_STATION_JSON = "/real-example-of-gas-stations-from-spanish-government.json"

class GasStationsRetrieverFromSpanishGovernmentShould {
    @Test
    fun deserializeToGasStationInfo() {
        val requester: URLWrapper = mock(URLWrapper::class.java)
        val file = javaClass.getResource(EXPECTED_GAS_STATION_JSON)?.readText()
        `when`(requester.get(anyString())).thenReturn(file)
        val gasStationsRetrieverFromSpanishGovernment = GasStationsRetrieverFromSpanishGovernment(requester)
        var gasStationsInfo = gasStationsRetrieverFromSpanishGovernment.apply()
        assertEquals(gasStation(), gasStationsInfo)
    }
}
