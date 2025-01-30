package com.lunatcoms.shopexplorer.presentation.viewmodel

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lunatcoms.shopexplorer.data.model.MapImages
import com.lunatcoms.shopexplorer.domain.usecase.GetMapUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MapViewModel @Inject constructor(
    private val getMapUseCase: GetMapUseCase
) : ViewModel() {

    private var _maps = MutableLiveData<MapImages>()
    val maps: LiveData<MapImages> = _maps

    init {
        fetchMap()
    }

    private fun fetchMap() {
        viewModelScope.launch{
            val result = getMapUseCase()
            _maps.value = result
        }
    }
}