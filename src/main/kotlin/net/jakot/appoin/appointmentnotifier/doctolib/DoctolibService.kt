package net.jakot.appoin.appointmentnotifier.doctolib

import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Service
class DoctolibService(
    private val doctolibRestClient: DoctolibRestClient
) {
    fun firstAvailableBefore(firstAvailableSearchData: FirstAvailableSearchData): LocalDate? {
        val availableTimes = doctolibRestClient.getAvailableTimes(buildAvailableTimesQuery(firstAvailableSearchData))
            ?: throw RuntimeException("A problem occurred while getting available times")
        if (availableTimes.total > 0) {
            availableTimes.availabilities
                .filter { it.slots.isNotEmpty() }
                .forEach { availability ->
                    LocalDate.parse(availability.slots.min(), DateTimeFormatter.ISO_OFFSET_DATE_TIME).let {
                        if (it.isBefore(firstAvailableSearchData.dateThreshold)) {
                            return it
                        }
                    }
                }
        } else {
            LocalDate.parse(availableTimes.nextSlot, DateTimeFormatter.ISO_OFFSET_DATE_TIME).let {
                if (it.isBefore(firstAvailableSearchData.dateThreshold)) {
                    return it
                }
            }
        }
        println { "There are no available times before ${firstAvailableSearchData.dateThreshold}" }
        return null
    }
}
