package com.hiremarknolan.nearbyplaces

import androidx.compose.runtime.Composable
import com.hiremarknolan.nearbyplaces.ui.composables.BottomNavigator
import com.hiremarknolan.nearbyplaces.ui.composables.NearbyPlacesScaffold
import com.hiremarknolan.nearbyplaces.ui.composables.TopBar

@Composable
fun NearbyPlacesApp() {
    NearbyPlacesScaffold(
        topBar = { TopBar(it) },
        bottomNavigator = { BottomNavigator() }
    )
}
