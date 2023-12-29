package net.jakot.appoin.appointmentnotifier.rest

import net.jakot.appoin.appointmentnotifier.doctolib.DoctolibService
import net.jakot.appoin.appointmentnotifier.doctolib.SEARCH_DATA_DEFAULT
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

@RestController
@RequestMapping("/api")
class RestController(
    private val doctolibService: DoctolibService
) {

    @GetMapping("/hello")
    fun hello(@RequestParam date: LocalDate): String {
        return doctolibService.firstAvailableBefore(SEARCH_DATA_DEFAULT.copy(dateThreshold = date)).toString()
    }
}
