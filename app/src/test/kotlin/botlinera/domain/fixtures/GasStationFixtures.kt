package botlinera.domain.fixtures

import botlinera.infrastructure.dtos.GasStation

class GasStationFixtures {
    companion object {
        fun gasStation(): List<GasStation> = listOf(
            GasStation(
                "02250",
                "AVENIDA CASTILLA LA MANCHA, 26",
                "L-D: 07:00-22:00",
                "39,211417",
                "ABENGIBRE",
                "-1,539167",
                "Abengibre",
                "",
                "1,759",
                "",
                "",
                "",
                "ALBACETE",
            "CEPSA"
            )
        )
    }
}
