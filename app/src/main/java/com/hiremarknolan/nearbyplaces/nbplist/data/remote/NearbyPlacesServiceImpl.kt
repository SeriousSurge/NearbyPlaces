package com.hiremarknolan.nearbyplaces.nbplist.data.remote

import com.hiremarknolan.nearbyplaces.BuildConfig
import com.hiremarknolan.nearbyplaces.nbplist.data.remote.dto.NearbyPlacesResponse
import io.ktor.client.HttpClient
import io.ktor.client.features.ClientRequestException
import io.ktor.client.features.RedirectResponseException
import io.ktor.client.features.ServerResponseException
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.parameter
import io.ktor.client.request.url

class NearbyPlacesServiceImpl(
    private val client: HttpClient
) : NearbyPlacesService {

    override suspend fun getNearbyPlacesList(query: String): NearbyPlacesResponse {
        return try {
            return client.get {
                url(HttpRoutes.POSTS)
                header("Authorization", BuildConfig.SQUARE_API_KEY)
                parameter("fields",  NEARBY_PLACES_FIELDS)
                parameter("ll", PLACES_NEARBY_TO)
                parameter("query", query)
                parameter("limit", LONGEST_LIST)
            }
        } catch (e: Exception) {
            when (e) {
                is RedirectResponseException -> println("Error: ${e.response.status.description}") //3xx responses
                is ClientRequestException -> println("Error: ${e.response.status.description}") //4xx responses
                is ServerResponseException -> println("Error: ${e.response.status.description}") //5xx responses
                else -> println("Error: ${e.message}")
            }
            NearbyPlacesResponse(emptyList())
        }
    }

    companion object {
        const val NEARBY_PLACES_FIELDS = "fsq_id,categories,location,geocodes,name"
        const val PLACES_NEARBY_TO = "52.4972,13.2411"

        const val SHORT_LIST = "5"
        const val LONG_LIST = "25"
        const val LONGEST_LIST = "50"
    }
}