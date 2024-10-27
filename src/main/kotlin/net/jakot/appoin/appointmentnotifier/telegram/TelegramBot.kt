package net.jakot.appoin.appointmentnotifier.telegram

import mu.KotlinLogging
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.objects.Update

class TelegramBot(botToken: String, private val botName: String, private val router: TelegramBotRouter) : TelegramLongPollingBot(botToken) {

    private val log = KotlinLogging.logger {}
    override fun getBotUsername(): String {
        return botName
    }

    override fun onUpdateReceived(update: Update?) {
        update?.let {
            router.route(it)
        }
    }
}
