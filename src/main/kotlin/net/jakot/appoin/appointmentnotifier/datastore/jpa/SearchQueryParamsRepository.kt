package net.jakot.appoin.appointmentnotifier.datastore.jpa

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface SearchQueryParamsRepository : JpaRepository<SearchQueryParams, UUID>