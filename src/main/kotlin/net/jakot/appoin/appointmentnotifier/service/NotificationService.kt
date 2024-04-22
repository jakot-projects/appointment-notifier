package net.jakot.appoin.appointmentnotifier.service

import net.jakot.appoin.appointmentnotifier.config.log
import net.jakot.appoin.appointmentnotifier.doctolib.DOCTOR_IDS
import net.jakot.appoin.appointmentnotifier.doctolib.DoctolibService
import net.jakot.appoin.appointmentnotifier.doctolib.SEARCH_DATA_DEFAULT
import net.jakot.appoin.appointmentnotifier.telegram.TelegramBotService
import org.springframework.stereotype.Service
import java.time.LocalDate

private val DATE_THRESHOLD = LocalDate.of(2024, 1, 10)

@Service
class NotificationService (
    private val doctolibService: DoctolibService,
    private val telegramBotService: TelegramBotService
) {
    fun sendNotification() {
        log.info { "Checking available appointments" }
        DOCTOR_IDS.forEach { doctorId ->
            log.info { "Checking available appointments for doctor $doctorId" }
            doctolibService.firstAvailableBefore(SEARCH_DATA_DEFAULT.copy(doctor = doctorId, dateThreshold = DATE_THRESHOLD))?.let {
                log.info { "First available appointment for doctor $doctorId is $it" }
                telegramBotService.sendNotification("First available appointment for doctor $doctorId is $it")
            } ?: let {
                log.info { "No available appointments for doctor $doctorId" }
                telegramBotService.sendNotification("No available appointments for doctor $doctorId")
            }
        }
    }
}
