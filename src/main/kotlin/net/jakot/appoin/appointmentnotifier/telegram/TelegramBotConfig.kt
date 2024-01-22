package net.jakot.appoin.appointmentnotifier.telegram

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.context.event.EventListener
import org.telegram.telegrambots.meta.TelegramBotsApi
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession

@Configuration
class TelegramBotConfig {

    @Value("\${telegram.bot.token}")
    private lateinit var botToken: String

    @Value("\${telegram.bot.name}")
    private lateinit var botName: String

    @Bean
    fun telegramBot(): TelegramBot {
        return TelegramBot(botToken, botName)
    }

    @EventListener(ContextRefreshedEvent::class)
    fun registerTelegrsmBot() {
        TelegramBotsApi(DefaultBotSession::class.java).registerBot(telegramBot())
    }
}
