package com.hiremarknolan.nearbyplaces.nbpdetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import com.hiremarknolan.nearbyplaces.composables.sheets.TopSheet
import com.hiremarknolan.nearbyplaces.nbplist.data.remote.dto.NearbyPlace

data class NearbyPlaceDetailScreen(val nearbyPlace: NearbyPlace) : Screen {

    @Composable
    override fun Content() {
        val targetLocation = LatLng(
            nearbyPlace.geocodes.main.latitude,
            nearbyPlace.geocodes.main.longitude
        )

        val cameraPositionState = rememberCameraPositionState {
            position = CameraPosition.fromLatLngZoom(targetLocation, 13f)
        }

        Column {
            TopSheet(
                title = nearbyPlace.name,
                url = nearbyPlace.getUrl(),
                subtitle = nearbyPlace.location.formatted_address
            )

            GoogleMap(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                cameraPositionState = cameraPositionState,
            ) {
                Marker(
                    state = MarkerState(position = targetLocation),
                    title = "Marker"
                )
            }
        }
    }
}
