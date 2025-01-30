package com.lunatcoms.shopexplorer.domain.usecase

import android.util.Log
import com.lunatcoms.shopexplorer.data.model.MapImages
import com.lunatcoms.shopexplorer.domain.repository.FortniteRepository
import javax.inject.Inject

class GetMapUseCase @Inject constructor(
    private val repository: FortniteRepository
) {
    suspend operator fun invoke(): MapImages{
        return repository.getMap()
    }
}