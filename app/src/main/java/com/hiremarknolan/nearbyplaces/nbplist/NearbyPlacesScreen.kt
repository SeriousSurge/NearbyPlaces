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
import com.hiremarknolan.nearbyplaces.composables.sheets.TopSheet
import com.hiremarknolan.nearbyplaces.core.viewmodel.viewModel
import com.hiremarknolan.nearbyplaces.destinations.NearbyPlaceDetailScreenDestination
import com.hiremarknolan.nearbyplaces.nbplist.composables.NearbyLocation
import com.hiremarknolan.nearbyplaces.nbplist.data.remote.dto.NearbyPlace
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination(start = true)
@Composable
fun NearbyPlaceListScreen(
    navigator: DestinationsNavigator,
    viewModel: NearbyPlacesListViewModel = viewModel()
) {
    var query by remember { mutableStateOf("") }

    var nearbyPlaceList by remember { mutableStateOf(emptyList<NearbyPlace>()) }

    Column {

        nearbyPlaceList.firstOrNull()?.let {
            TopSheet(
                it.name,
                it.getUrl(),
            ) { navigator.navigate(NearbyPlaceDetailScreenDestination(it)) }
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
                NearbyLocation(it) { navigator.navigate(NearbyPlaceDetailScreenDestination(it)) }
            }
        }
    }

    LaunchedEffect(query) {
        nearbyPlaceList = viewModel.service.getNearbyPlacesList(query).results
    }
}