package com.hiremarknolan.nearbyplaces.nbpdetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import com.hiremarknolan.nearbyplaces.composables.sheets.TopSheet
import com.hiremarknolan.nearbyplaces.core.viewmodel.viewModel
import com.ramcosta.composedestinations.annotation.Destination

@Destination(navArgsDelegate = NearbyPlacesListDetailScreenNavArgs::class)
@Composable
fun NearbyPlaceDetailScreen(
    viewModel: NearbyPlaceDetailViewModel = viewModel()
) {
    val targetLocation = LatLng(
        viewModel.nearbyPlace.geocodes.main.latitude,
        viewModel.nearbyPlace.geocodes.main.longitude
    )

    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(targetLocation, 13f)
    }

    Column {
        TopSheet(
            title = viewModel.nearbyPlace.name,
            url = viewModel.nearbyPlace.getUrl(),
            subtitle = viewModel.nearbyPlace.location.formatted_address
        )

        GoogleMap(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            cameraPositionState = cameraPositionState,
        ) {
            Marker(
                state = MarkerState(position = targetLocation),
                title = viewModel.nearbyPlace.name
            )
        }
    }

}
