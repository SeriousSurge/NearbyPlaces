package com.hiremarknolan.nearbyplaces.nbplist

import androidx.lifecycle.ViewModel
import com.hiremarknolan.nearbyplaces.nbplist.data.remote.NearbyPlacesService

class NearbyPlacesListViewModel : ViewModel() {

    val service = NearbyPlacesService.create()

}