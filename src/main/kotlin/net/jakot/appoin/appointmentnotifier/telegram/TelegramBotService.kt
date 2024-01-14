package net.jakot.appoin.appointmentnotifier.telegram

import org.springframework.stereotype.Service
import org.telegram.telegrambots.meta.api.methods.send.SendMessage

@Service
class TelegramBotService(
    private val telegramBot: TelegramBot
) {
    fun sendNotification(message: String) {
        SendMessage().apply {
            chatId = "317041967"
            text = message
        }.let {
            telegramBot.execute(it)
        }
    }
}
