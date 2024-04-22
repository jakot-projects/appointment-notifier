package net.jakot.appoin.appointmentnotifier.telegram

import org.springframework.stereotype.Service
import org.telegram.telegrambots.meta.api.objects.Update

@Service
class MessageHandler {
    fun handle(it: Update) {
        val message = it.message
        if (message.hasText()) {
            val text = message.text
            if (text.startsWith("/start")) {
                // do later
            }
        }
    }
}
