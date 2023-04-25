package com.hiremarknolan.nearbyplaces.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen

object SettingsScreen : Screen {
    @Composable
    override fun Content() {
        SettingsScreen()
    }
}

@Composable
fun SettingsScreen() {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Settings", style = typography.h3)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "This is a sample Settings screen", style = typography.body1)
    }
}