package com.hiremarknolan.nearbyplaces.ui.composables

import androidx.annotation.StringRes
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.hiremarknolan.nearbyplaces.NavGraphs
import com.hiremarknolan.nearbyplaces.R
import com.hiremarknolan.nearbyplaces.destinations.DirectionDestination
import com.hiremarknolan.nearbyplaces.destinations.NearbyPlaceListScreenDestination
import com.hiremarknolan.nearbyplaces.destinations.SettingsScreenDestination
import com.ramcosta.composedestinations.navigation.navigate
import com.ramcosta.composedestinations.navigation.popBackStack
import com.ramcosta.composedestinations.navigation.popUpTo
import com.ramcosta.composedestinations.utils.isRouteOnBackStack

@Composable
fun BottomBar(
    navController: NavHostController
) {
    BottomNavigation {
        BottomBarItem.values().forEach { destination ->
            val isCurrentDestOnBackStack = navController.isRouteOnBackStack(destination.direction)

            BottomNavigationItem(
                selected = isCurrentDestOnBackStack,
                onClick = {
                    if (isCurrentDestOnBackStack) {
                        // When we click again on a bottom bar item and it was already selected
                        // we want to pop the back stack until the initial destination of this bottom bar item
                        navController.popBackStack(destination.direction, false)
                        return@BottomNavigationItem
                    }

                    navController.navigate(destination.direction) {
                        // Pop up to the root of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        popUpTo(NavGraphs.root) {
                            saveState = true
                        }

                        // Avoid multiple copies of the same destination when
                        // re-selecting the same item
                        launchSingleTop = true
                        // Restore state when re-selecting a previously selected item
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        destination.icon,
                        contentDescription = stringResource(destination.label)
                    )
                },
                label = { Text(stringResource(destination.label), style = typography.caption) },
            )
        }
    }
}

enum class BottomBarItem(
    val direction: DirectionDestination,
    val icon: ImageVector,
    @StringRes val label: Int
) {
    NearbyPlacesList(NearbyPlaceListScreenDestination, Icons.Default.List, R.string.nearby_place_list_screen),
    Settings(SettingsScreenDestination, Icons.Default.Settings, R.string.settings_screen)
}