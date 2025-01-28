package com.lunatcoms.shopexplorer.domain.usecase

import com.lunatcoms.shopexplorer.data.model.SkinData
import com.lunatcoms.shopexplorer.domain.repository.FortniteRepository
import javax.inject.Inject

class GetSkinsUseCase @Inject constructor(
    private val repository: FortniteRepository
) {
    suspend operator fun invoke(): List<SkinData>{
        return repository.getSkins()
            .filter { it.type.value == "outfit" }
            .sortedByDescending { it.added }
    }
}