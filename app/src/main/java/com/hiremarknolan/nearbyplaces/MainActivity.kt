package com.hiremarknolan.nearbyplaces

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import com.hiremarknolan.nearbyplaces.ui.theme.NearbyPlacesTheme
import com.hiremarknolan.nearbyplaces.core.di.DependencyContainer

val LocalDependencyContainer = staticCompositionLocalOf<DependencyContainer> {
    error("No dependency container provided!")
}

class MainActivity : ComponentActivity() {

    private val dependencyContainer by lazy { DependencyContainer(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            NearbyPlacesTheme {
                CompositionLocalProvider(LocalDependencyContainer provides dependencyContainer) {
                    NearbyPlacesApp()
                }
            }
        }
    }
}