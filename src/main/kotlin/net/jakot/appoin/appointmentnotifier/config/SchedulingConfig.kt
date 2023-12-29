package net.jakot.appoin.appointmentnotifier.config

import mu.KotlinLogging
import net.jakot.appoin.appointmentnotifier.doctolib.DOCTOR_IDS
import net.jakot.appoin.appointmentnotifier.doctolib.DoctolibService
import net.jakot.appoin.appointmentnotifier.doctolib.SEARCH_DATA_DEFAULT
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import java.time.LocalDate

const val CRON_EVERY_10_MINUTES = "0 */15 * * * *"
private val DATE_THRESHOLD = LocalDate.of(2024, 1, 10)

val log = KotlinLogging.logger {}


@Configuration
@EnableScheduling
class SchedulingConfig(
    private val doctolibService: DoctolibService
) {


    @Scheduled(cron = CRON_EVERY_10_MINUTES)
    fun scheduleCheckAvailableAppointments() {
        log.info { "Checking available appointments" }
        DOCTOR_IDS.forEach { doctorId ->
            log.info { "Checking available appointments for doctor $doctorId" }
            log.info {
                doctolibService.firstAvailableBefore(SEARCH_DATA_DEFAULT.copy(doctor = doctorId, dateThreshold = DATE_THRESHOLD))?.let {
                    "First available appointment for doctor $doctorId is $it"
                } ?: "No available appointments for doctor $doctorId"
            }
        }
    }
}
