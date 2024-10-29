package net.jakot.appoin.appointmentnotifier.datastore.jpa

import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.sql.Timestamp
import java.util.*

@Entity
class SearchQueryParams(
    @Id
    var id: UUID? = null,
    val visitMotive: String,
    val agendaId: String,
    val practiceId: String,
    val untilDate: Timestamp,
    val frequency: Byte
)