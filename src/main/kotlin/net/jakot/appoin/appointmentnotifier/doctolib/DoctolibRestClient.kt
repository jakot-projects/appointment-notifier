package net.jakot.appoin.appointmentnotifier.doctolib

import net.jakot.appoin.appointmentnotifier.doctolib.dto.Availabilities
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component
class DoctolibRestClient(
    private val doctolibRestTemplate: RestTemplate
) {

    fun getAvailableTimes(query: String): Availabilities? {
        val responseEntity = doctolibRestTemplate.exchange("$AVAILABLE_TIMES_API?$query", HttpMethod.GET, null, Availabilities::class.java)
        return responseEntity.body
    }
}
