package com.lunatcoms.shopexplorer.presentation.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lunatcoms.shopexplorer.data.model.SkinDetailData
import com.lunatcoms.shopexplorer.data.model.SkinDetailResponse
import com.lunatcoms.shopexplorer.domain.usecase.GetSkinDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class SkinDetailViewModel @Inject constructor(
    private val getSkinDetailUseCase: GetSkinDetailUseCase
) : ViewModel() {

    private val _detailSkin = MutableLiveData<SkinDetailResponse?>()
    val detailSkin: LiveData<SkinDetailResponse?> = _detailSkin

    fun fetchDetailSkin(idSkin: String) {
        viewModelScope.launch {
            try {
                val result = getSkinDetailUseCase(idSkin)
                _detailSkin.value = result
            } catch (exception: Exception){
                _detailSkin.value = null
            }
        }
    }
}