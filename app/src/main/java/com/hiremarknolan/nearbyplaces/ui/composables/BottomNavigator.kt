package com.hiremarknolan.nearbyplaces.ui.composables

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import com.hiremarknolan.nearbyplaces.ui.composables.tabs.NearbyPlaceListTab
import com.hiremarknolan.nearbyplaces.ui.composables.tabs.SettingsTab

@Composable
fun BottomNavigator() {
    BottomNavigation {
        TabNavigationItem(NearbyPlaceListTab)
        TabNavigationItem(SettingsTab)
    }
}

@Composable
private fun RowScope.TabNavigationItem(tab: Tab) {
    val tabNavigator = LocalTabNavigator.current

    BottomNavigationItem(
        selected = tabNavigator.current == tab,
        onClick = { tabNavigator.current = tab },
        icon = {
            tab.options.icon?.let { Icon(painter = it, contentDescription = tab.options.title) }
        }
    )
}