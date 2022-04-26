/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package botlinera.infrastructure

import botlinera.application.usecases.RetrieveGasStations
import botlinera.infrastructure.adapters.GasStationsRetrieverFromSpanishGovernment
import botlinera.infrastructure.utils.URLWrapper
import botlinera.infrastucture.adapters.GastStationPersisterMongo

fun main() {
    println("Botlinera is now working!")
    RetrieveGasStations(GasStationsRetrieverFromSpanishGovernment(URLWrapper()), GastStationPersisterMongo()).execute()
}
