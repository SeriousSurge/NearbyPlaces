package com.hiremarknolan.nearbyplaces.ui.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import com.hiremarknolan.nearbyplaces.core.viewmodel.viewModel
import com.hiremarknolan.nearbyplaces.destinations.Destination
import com.hiremarknolan.nearbyplaces.destinations.NearbyPlaceDetailScreenDestination
import com.hiremarknolan.nearbyplaces.destinations.NearbyPlaceListScreenDestination
import com.hiremarknolan.nearbyplaces.destinations.SettingsScreenDestination
import com.hiremarknolan.nearbyplaces.nbpdetail.NearbyPlaceDetailViewModel

@Composable
fun TopBar(
    destination: Destination,
    navBackStackEntry: NavBackStackEntry?
) {
    TopAppBar {
        Text(
            text = destination.topBarTitle(navBackStackEntry),
            style = typography.h2,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.padding(horizontal = 12.dp)
        )
    }
}

@Composable
fun Destination.topBarTitle(navBackStackEntry: NavBackStackEntry?): String {
    return when (this) {
        NearbyPlaceDetailScreenDestination-> {
            // Here you can also call another Composable on another file like TaskScreenTopBar
            // 👇 access the same viewmodel instance the screen is using, by passing the back stack entry
            val nearbyPlace = navBackStackEntry?.let {
                viewModel<NearbyPlaceDetailViewModel>(navBackStackEntry).nearbyPlace
            }
            "A place nearby" //nearbyPlace?.name
        }

        NearbyPlaceListScreenDestination -> "Places Nearby"
        SettingsScreenDestination -> "Setting"
    }
}