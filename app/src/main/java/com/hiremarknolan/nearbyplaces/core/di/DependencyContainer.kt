package com.hiremarknolan.nearbyplaces.core.di

import androidx.lifecycle.SavedStateHandle
import com.hiremarknolan.nearbyplaces.MainActivity
import com.hiremarknolan.nearbyplaces.navArgs
import com.hiremarknolan.nearbyplaces.nbpdetail.NearbyPlaceDetailViewModel
import com.hiremarknolan.nearbyplaces.nbpdetail.NearbyPlacesListDetailScreenNavArgs
import com.hiremarknolan.nearbyplaces.nbplist.NearbyPlacesListViewModel
import com.hiremarknolan.nearbyplaces.settings.SettingsViewModel

class DependencyContainer(
    val activity: MainActivity
) {
    @Suppress("UNCHECKED_CAST")
    fun <T> createViewModel(modelClass: Class<T>, handle: SavedStateHandle): T {
        return when (modelClass) {
            NearbyPlacesListViewModel::class.java -> NearbyPlacesListViewModel()
            SettingsViewModel::class.java -> SettingsViewModel()
            NearbyPlaceDetailViewModel::class.java -> NearbyPlaceDetailViewModel(
                handle.navArgs<NearbyPlacesListDetailScreenNavArgs>().nearbyPlace
            )
            else -> throw RuntimeException("Unknown view model $modelClass")
        } as T
    }
}