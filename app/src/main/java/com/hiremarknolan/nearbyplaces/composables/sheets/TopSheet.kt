package com.hiremarknolan.nearbyplaces.composables.sheets

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hiremarknolan.nearbyplaces.composables.buttons.ShareButton

@Composable
fun TopSheet(title: String, url: String, subtitle: String? = null, onClick: () -> Unit = { }) {
    Row(
        Modifier
            .fillMaxWidth()
            .background(colors.primaryVariant)
            .clickable(onClick = onClick)
            .padding(16.dp), //todo - to semantic values
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(Modifier.weight(1f)) {
            if (subtitle.isNullOrBlank()) Text(title, style = typography.h1, color = colors.onPrimary)
            else {
                Text(title, style = typography.h2, color = colors.onPrimary)
                Text(subtitle, style = typography.h4, color = colors.onPrimary)
            }
        }

        ShareButton(url, title)
    }
}