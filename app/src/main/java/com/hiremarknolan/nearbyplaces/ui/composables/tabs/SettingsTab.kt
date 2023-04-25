package com.hiremarknolan.nearbyplaces.ui.composables.tabs

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.stringResource
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.hiremarknolan.nearbyplaces.R
import com.hiremarknolan.nearbyplaces.settings.SettingsScreen

object SettingsTab : Tab {

    override val options: TabOptions
        @Composable
        get() {
            val title = stringResource(R.string.settings_screen)
            val icon = rememberVectorPainter(Icons.Default.Settings)

            return remember {
                TabOptions(
                    index = 0u,
                    title = title,
                    icon = icon
                )
            }
        }

    @Composable
    override fun Content() {
        TabContent(root = SettingsScreen)
    }
}