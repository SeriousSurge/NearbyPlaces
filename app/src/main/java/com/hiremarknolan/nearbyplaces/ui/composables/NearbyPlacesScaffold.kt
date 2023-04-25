package com.hiremarknolan.nearbyplaces.ui.composables

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.hiremarknolan.nearbyplaces.appCurrentDestinationAsState
import com.hiremarknolan.nearbyplaces.destinations.Destination
import com.hiremarknolan.nearbyplaces.startAppDestination
import com.ramcosta.composedestinations.spec.Route

@Composable
fun NearbyPlacesScaffold(
    startRoute: Route,
    navController: NavHostController,
    topBar: @Composable (Destination, NavBackStackEntry?) -> Unit,
    bottomBar: @Composable (Destination) -> Unit,
    content: @Composable (PaddingValues) -> Unit,
) {
    val destination = navController.appCurrentDestinationAsState().value
        ?: startRoute.startAppDestination
    val navBackStackEntry = navController.currentBackStackEntry

    // 👇 only for debugging, you shouldn't use currentBackStack API as it is restricted by annotation
    navController.currentBackStack.collectAsState().value.print()

    Scaffold(
        topBar = { topBar(destination, navBackStackEntry) },
        bottomBar = { bottomBar(destination) },
        content = content
    )

}

private fun Collection<NavBackStackEntry>.print(prefix: String = "stack") {
    val stack = map { it.destination.route }.toTypedArray().contentToString()
    println("$prefix = $stack")
}