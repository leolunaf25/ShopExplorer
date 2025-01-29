package com.lunatcoms.shopexplorer.domain.usecase

import com.lunatcoms.shopexplorer.data.model.ShopData
import com.lunatcoms.shopexplorer.domain.repository.FortniteRepository
import javax.inject.Inject

class GetShopUseCase @Inject constructor(
    private val repository: FortniteRepository
) {
    suspend operator fun invoke(): List<ShopData>{
        return repository.getShop()
    }
}