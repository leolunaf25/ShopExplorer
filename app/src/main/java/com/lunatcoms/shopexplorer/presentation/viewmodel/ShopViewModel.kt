package com.lunatcoms.shopexplorer.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lunatcoms.shopexplorer.domain.model.ShopItem
import com.lunatcoms.shopexplorer.domain.usecase.GetShopUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShopViewModel @Inject constructor(
    private val getShopUseCase: GetShopUseCase
) : ViewModel() {

    private val _shops = MutableLiveData<List<ShopItem>?>()
    val shops: LiveData<List<ShopItem>?> = _shops

    init {
        fetchShop()
    }

    private fun fetchShop() {
        viewModelScope.launch {
            val result = getShopUseCase()
            _shops.value = result
        }
    }
}
