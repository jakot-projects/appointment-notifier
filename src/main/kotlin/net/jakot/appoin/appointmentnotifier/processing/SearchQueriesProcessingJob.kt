package net.jakot.appoin.appointmentnotifier.processing

import net.jakot.appoin.appointmentnotifier.config.CRON_EVERY_5_MINUTES
import net.jakot.appoin.appointmentnotifier.datastore.jpa.SearchQueryParams
import net.jakot.appoin.appointmentnotifier.datastore.jpa.SearchQueryParamsRepository
import net.jakot.appoin.appointmentnotifier.doctolib.DoctolibService
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service

@Service
class SearchQueriesProcessingJob(
    val searchQueryParamsRepository: SearchQueryParamsRepository,
    val doctolibService: DoctolibService
) {

    @Scheduled(cron = CRON_EVERY_5_MINUTES)
    fun processSearchQueries() {
        val searchQueries = findSearchQueries()

    }

    private fun findSearchQueries(): MutableList<SearchQueryParams> {
        return searchQueryParamsRepository.findAll()
    }


}