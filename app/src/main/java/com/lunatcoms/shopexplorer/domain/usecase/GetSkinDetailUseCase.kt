package com.lunatcoms.shopexplorer.domain.usecase

import com.lunatcoms.shopexplorer.data.model.SkinDetailData
import com.lunatcoms.shopexplorer.data.model.SkinDetailResponse
import com.lunatcoms.shopexplorer.domain.repository.FortniteRepository
import javax.inject.Inject

class GetSkinDetailUseCase @Inject constructor(
    private val repository: FortniteRepository
){
    suspend operator fun invoke(idSkin:String): SkinDetailResponse{
        return repository.getDetailSkin(idSkin)
    }

}