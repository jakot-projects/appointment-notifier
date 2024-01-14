package net.jakot.appoin.appointmentnotifier.doctolib

import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate
import java.time.LocalDate
import java.time.format.DateTimeFormatter

const val SITE_BASE_URL = "https://www.doctolib.de"
const val AVAILABLE_TIMES_API = "/availabilities.json"
val DOCTOR_IDS = arrayListOf(/*"638502", "861116", "336323", "336693", "336322",*/ "336321")
val SEARCH_DATA_DEFAULT = FirstAvailableSearchData(visitMotive = "2126313", practice = "133110", doctor = "638502", dateThreshold = LocalDate.now())

fun buildAvailableTimesQuery(visitMotive: String, agendaId: String, practiceId: String, startDate: String): String {
    return "visit_motive_ids=$visitMotive&agenda_ids=${agendaId}&practice_ids=${practiceId}&insurance_sector=public&telehealth=false&limit=5&start_date=${startDate}"
}

fun buildAvailableTimesQuery(firstAvailableSearchData: FirstAvailableSearchData): String {
    return buildAvailableTimesQuery(firstAvailableSearchData.visitMotive, firstAvailableSearchData.doctor, firstAvailableSearchData.practice, LocalDate.now().format(DateTimeFormatter.ISO_DATE))
}


@Configuration
class DoctolibConfig {
    @Bean
    fun doctolibRestTemplate(): RestTemplate {
        return RestTemplateBuilder()
            .rootUri(SITE_BASE_URL)
            .defaultHeader("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36", "eltabo")
            .build()
    }
}

data class FirstAvailableSearchData(
    val visitMotive: String,
    val practice: String,
    val doctor: String,
    val dateThreshold: LocalDate
)
