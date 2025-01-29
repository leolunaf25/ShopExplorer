package com.lunatcoms.shopexplorer.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lunatcoms.shopexplorer.data.model.SkinData
import com.lunatcoms.shopexplorer.domain.usecase.GetSkinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SkinsViewModel @Inject constructor(
    private val getSkinsUseCase: GetSkinsUseCase
):ViewModel() {

    private val _skins = MutableLiveData<List<SkinData>?>()
    val skins: LiveData<List<SkinData>?> = _skins

    private var allSkins = emptyList<SkinData>()

    init {
        fetchSkins()
    }

    private fun fetchSkins() {
        viewModelScope.launch {
            val result = getSkinsUseCase()
            allSkins = result
            _skins.value = result // Inicializa con la lista completa
        }
    }

    fun searchSkins(query: String) {
        _skins.value = if (query.isBlank()) {
            allSkins
        } else {
            allSkins.filter { it.name.contains(query, ignoreCase = true) }
        }
    }
}