package com.hiremarknolan.nearbyplaces.nbplist.data.remote

import com.hiremarknolan.nearbyplaces.nbplist.data.remote.dto.NearbyPlacesResponse
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer

interface NearbyPlacesService {
    suspend fun getNearbyPlacesList(query: String = ""): NearbyPlacesResponse

    companion object {
        fun create(): NearbyPlacesService {
            return NearbyPlacesServiceImpl(
                client = HttpClient(Android) {
                    install(JsonFeature) {
                        serializer = KotlinxSerializer()
                    }
                }
            )
        }
    }
}