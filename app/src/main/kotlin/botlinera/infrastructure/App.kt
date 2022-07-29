/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package botlinera.infrastructure

import botlinera.application.usecases.UpdateGasStations
import botlinera.infrastructure.adapters.GasStationPersisterMongo
import botlinera.infrastructure.adapters.GasStationsRetrieverFromSpanishGovernment
import botlinera.infrastructure.bot.TelegramBot
import botlinera.infrastructure.dtos.GasStationDto
import botlinera.infrastructure.schedulers.GasStationScheduler
import botlinera.infrastructure.utils.URLWrapper
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase
import org.litote.kmongo.KMongo
import org.litote.kmongo.getCollectionOfName


fun main() {
    val gasStationPersister = GasStationPersisterMongo(mongoCollection())

    GasStationScheduler().start {
        UpdateGasStations(
            GasStationsRetrieverFromSpanishGovernment(URLWrapper()),
            gasStationPersister
        ).execute()
    }
    TelegramBot().startPolling()
}

private fun mongoCollection(): MongoCollection<GasStationDto> {
    val client: MongoClient = KMongo.createClient(System.getenv("DATABASE_URL"))
    val database: MongoDatabase = client.getDatabase("botlinera")
    return database.getCollectionOfName<GasStationDto>("gas_stations")
}


