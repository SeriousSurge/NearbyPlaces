package com.hiremarknolan.nearbyplaces.nbplist.data.remote.dto

import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import org.junit.Test

class NearbyPlaceResponseOperatorTests {
    @Test
    fun`should generate correct CategoryIcon url`() {
        assertEquals(
            CategoryIcon("https://ss1.4sqi.net/img/categories_v2/arts_entertainment/performingarts_dancestudio_", ".png").getUrl(),
            "https://ss1.4sqi.net/img/categories_v2/arts_entertainment/performingarts_dancestudio_64.png"
        )
    }

    @Test
    fun`should generate correct fsq_id url`() {
        assertEquals(
            NearbyPlace(
                categories = mockk(),
                fsq_id = "560d09a0498e04e7a4318441",
                geocodes = mockk(),
                location = mockk(),
                name = "name",
            ).getUrl(),
            "https://foursquare.com/v/560d09a0498e04e7a4318441"
        )
    }
}