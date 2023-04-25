package com.hiremarknolan.nearbyplaces.nbplist.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class NearbyPlacesResponse(
    val results: List<NearbyPlace>
)

@Serializable
data class NearbyPlace(
    val categories: List<Category>,
    val fsq_id: String,
    val geocodes: Geocodes,
    val location: Location,
    val name: String
) {
    fun getUrl(): String ="https://foursquare.com/v/" + this.fsq_id

}

@Serializable
data class Category(
    val icon: CategoryIcon,
    val id: Int,
    val name: String
)

@Serializable
data class Geocodes(
    val drop_off: DropOff? = null,
    val main: Main,
    val roof: Roof? = null
)

@Serializable
data class Location(
    val address: String? = null,
    val country: String? = null,
    val cross_street: String? = null,
    val formatted_address: String,
    val locality: String? = null,
    val postcode: String? = null,
    val region: String? = null
)

@Serializable
data class CategoryIcon(
    val prefix: String,
    val suffix: String
) {
    fun getUrl() = prefix + "64" + suffix
}

@Serializable
data class DropOff(
    val latitude: Double,
    val longitude: Double
)

@Serializable
data class Main(
    val latitude: Double,
    val longitude: Double
)

@Serializable
data class Roof(
    val latitude: Double,
    val longitude: Double
)