package net.jakot.appoin.appointmentnotifier.telegram

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.context.event.EventListener
import org.telegram.telegrambots.meta.TelegramBotsApi
import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand
import org.telegram.telegrambots.meta.api.objects.commands.scope.BotCommandScopeDefault
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession

@Configuration
class TelegramBotConfig {

    @Value("\${telegram.bot.token}")
    private lateinit var botToken: String

    @Value("\${telegram.bot.name}")
    private lateinit var botName: String

    @Bean
    fun telegramBot(router: TelegramBotRouter): TelegramBot {
        return TelegramBot(botToken, botName, router)
    }

    @EventListener(ContextRefreshedEvent::class)
    fun registerTelegramBot(telegramBot: TelegramBot) {
        TelegramBotsApi(DefaultBotSession::class.java).registerBot(telegramBot)
        initializeBot(telegramBot)
    }

    private fun initializeBot(telegramBot: TelegramBot) {
        val commands = ArrayList<BotCommand>()
        commands.add(BotCommand("start", "Start bot"))
        commands.add(BotCommand("requests", "List of requests"))
        commands.add(BotCommand("help", "Help menu"))
        telegramBot.execute(SetMyCommands(commands, BotCommandScopeDefault(), null))
    }
}
