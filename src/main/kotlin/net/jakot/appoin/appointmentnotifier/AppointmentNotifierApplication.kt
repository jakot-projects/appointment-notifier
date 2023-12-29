package net.jakot.appoin.appointmentnotifier

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AppointmentNotifierApplication

fun main(args: Array<String>) {
    runApplication<AppointmentNotifierApplication>(*args)
}
