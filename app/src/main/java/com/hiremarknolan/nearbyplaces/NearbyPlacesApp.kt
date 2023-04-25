package com.hiremarknolan.nearbyplaces

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.hiremarknolan.nearbyplaces.ui.composables.BottomBar
import com.hiremarknolan.nearbyplaces.ui.composables.TopBar
import com.hiremarknolan.nearbyplaces.ui.composables.NearbyPlacesScaffold
import com.ramcosta.composedestinations.animations.rememberAnimatedNavHostEngine
import com.ramcosta.composedestinations.DestinationsNavHost

@OptIn(ExperimentalMaterialNavigationApi::class, ExperimentalAnimationApi::class)
@Composable
fun NearbyPlacesApp() {

    val engine = rememberAnimatedNavHostEngine()
    val navController = engine.rememberNavController()

    val startRoute =  NavGraphs.root.startRoute

    NearbyPlacesScaffold(
        navController = navController,
        startRoute = NavGraphs.root.startRoute,
        topBar = { dest, backStackEntry ->
            TopBar(dest, backStackEntry)
        },
        bottomBar = {
            BottomBar(navController)
        }
    ) {
        DestinationsNavHost(
            engine = engine,
            navController = navController,
            navGraph = NavGraphs.root,
            modifier = Modifier.padding(it),
            startRoute = startRoute
        )

        ShowCurrentDestination(navController)
    }
}

@Composable
private fun ShowCurrentDestination(
    navController: NavHostController
) {
    val currentDestination by navController.appCurrentDestinationAsState()
    println("Your current dir is: ${currentDestination?.route}")
}