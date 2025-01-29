package com.lunatcoms.shopexplorer.domain.usecase

import com.lunatcoms.shopexplorer.data.model.Entry
import com.lunatcoms.shopexplorer.data.model.ShopData
import com.lunatcoms.shopexplorer.domain.repository.FortniteRepository
import javax.inject.Inject

class GetShopUseCase @Inject constructor(
    private val repository: FortniteRepository
) {
    suspend operator fun invoke(): List<Entry> {

        val shopData = repository.getShop()
        val entries = shopData.flatMap { it.entries }

        val filteredEntries = entries.filter {entry ->
            entry.layout?.name != "Jam Tracks"
        }

        return filteredEntries.sortedWith(compareBy<Entry> {
            it.layout?.name ?: "" }
            .thenByDescending { it.bundle != null }
            .thenByDescending { it.sortPriority }
        )
    }
}
