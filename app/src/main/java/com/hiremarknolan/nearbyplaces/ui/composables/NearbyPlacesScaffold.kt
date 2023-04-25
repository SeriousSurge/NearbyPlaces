package com.hiremarknolan.nearbyplaces.ui.composables

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.hiremarknolan.nearbyplaces.ui.composables.tabs.NearbyPlaceListTab

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun NearbyPlacesScaffold(
    topBar: @Composable (title: String) -> Unit,
    bottomNavigator: @Composable () -> Unit
) {
    TabNavigator(NearbyPlaceListTab) { navigator ->
        Scaffold(
            topBar = { topBar(navigator.current.options.title) },
            content = { CurrentTab() },
            bottomBar = { bottomNavigator() }
        )
    }
}