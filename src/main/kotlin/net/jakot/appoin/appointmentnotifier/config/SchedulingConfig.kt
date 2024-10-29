package net.jakot.appoin.appointmentnotifier.config

import mu.KotlinLogging
import net.jakot.appoin.appointmentnotifier.service.NotificationService
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled

val log = KotlinLogging.logger {}

@Configuration
@EnableScheduling
class SchedulingConfig(
    private val notificationService: NotificationService
) {

    @Scheduled(cron = CRON_EVERY_10_MINUTES)
    fun scheduleCheckAvailableAppointments() {
        //notificationService.sendNotification()
    }
}
