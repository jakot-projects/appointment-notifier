package net.jakot.appoin.appointmentnotifier.datastore.jpa

import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.util.UUID

@Entity
class UserEntity(
    @Id
    var userId: UUID? = null,
    val userExternalId: String
)