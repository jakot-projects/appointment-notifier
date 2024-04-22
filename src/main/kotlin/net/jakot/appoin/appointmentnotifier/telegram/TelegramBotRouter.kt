package net.jakot.appoin.appointmentnotifier.telegram

import org.springframework.stereotype.Service
import org.telegram.telegrambots.meta.api.objects.Update

@Service
class TelegramBotRouter(private val messageHandler: MessageHandler) {
    fun route(it: Update) {
        if (it.hasMessage()) {
            messageHandler.handle(it)
        }
    }
}
