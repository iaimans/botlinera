/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package botlinera.infrastructure

import botlinera.application.usecases.UpdateGasStations
import botlinera.infrastructure.adapters.GasStationsRetrieverFromSpanishGovernment
import botlinera.infrastructure.bot.TelegramBot
import botlinera.infrastructure.schedulers.GasStationScheduler
import botlinera.infrastructure.utils.URLWrapper
import botlinera.infrastructure.adapters.GastStationPersisterMongo


fun main() {
    val gasStationPersister = GastStationPersisterMongo(System.getenv("DATABASE_URL"))

    GasStationScheduler().start {
        UpdateGasStations(
            GasStationsRetrieverFromSpanishGovernment(URLWrapper()),
            gasStationPersister
        ).execute()
    }
    TelegramBot().startPolling()
}


