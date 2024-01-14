package net.jakot.appoin.appointmentnotifier.doctolib.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class Availabilities(
    val total: Int,
    val availabilities: List<Availability>,
    @JsonProperty("next_slot")
    val nextSlot: String?
)

data class Availability(
    val date: String,
    val slots: List<String>,
)
