package com.hiremarknolan.nearbyplaces.nbplist.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.hiremarknolan.nearbyplaces.nbplist.data.remote.dto.Category
import com.hiremarknolan.nearbyplaces.nbplist.data.remote.dto.NearbyPlace

@Composable
fun NearbyLocation(nearbyPlace: NearbyPlace, onClick: () -> Unit) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(colors.surface, RoundedCornerShape(4.dp))
            .clickable(onClick = onClick)
            .padding(8.dp)
    ) {
        Text(text = nearbyPlace.name, style = typography.h2)
        Spacer(Modifier.height(4.dp))
        Text(text = nearbyPlace.location.formatted_address, style = typography.subtitle1)
        nearbyPlace.categories.firstOrNull()?.let {
            CategorySection(it)
        }
    }
}

@Composable
private fun CategorySection(
    category: Category
) {
    Row(
        Modifier.padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = category.icon.getUrl(),
            contentDescription = null,
            modifier = Modifier
                .padding(vertical = 4.dp)
                .size(24.dp)
                .background(colors.primary, CircleShape)
        )
        Spacer(Modifier.width(8.dp))

        Text(text = category.name, style = typography.h4)
    }
}