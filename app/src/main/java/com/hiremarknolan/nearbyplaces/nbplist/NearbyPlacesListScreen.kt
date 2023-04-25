package com.hiremarknolan.nearbyplaces.nbplist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.hiremarknolan.nearbyplaces.composables.sheets.TopSheet
import com.hiremarknolan.nearbyplaces.nbpdetail.NearbyPlaceDetailScreen
import com.hiremarknolan.nearbyplaces.nbplist.composables.NearbyLocation
import com.hiremarknolan.nearbyplaces.nbplist.data.remote.NearbyPlacesService
import com.hiremarknolan.nearbyplaces.nbplist.data.remote.dto.NearbyPlace

object NearbyPlacesListScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val service = NearbyPlacesService.create()

        var query by remember { mutableStateOf("") }
        var nearbyPlaceList by remember { mutableStateOf(emptyList<NearbyPlace>()) }

        Column {

            nearbyPlaceList.firstOrNull()?.let {
                TopSheet(
                    it.name,
                    it.getUrl(),
                ) { navigator.push(NearbyPlaceDetailScreen(it)) }
            }

            OutlinedTextField(
                value = query,
                onValueChange = { query = it },
                placeholder = { Text(text = "Filter the results") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )

            LazyColumn(
                Modifier.fillMaxSize()
            ) {
                items(nearbyPlaceList.drop(1)) {
                    NearbyLocation(it) { navigator.push(NearbyPlaceDetailScreen(it)) }
                }
            }
        }

        LaunchedEffect(query) {
            nearbyPlaceList = service.getNearbyPlacesList(query).results
        }
    }
}