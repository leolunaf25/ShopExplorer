package com.lunatcoms.shopexplorer.domain.usecase

import com.lunatcoms.shopexplorer.data.model.Entry
import com.lunatcoms.shopexplorer.data.model.ShopData
import com.lunatcoms.shopexplorer.domain.model.ShopItem
import com.lunatcoms.shopexplorer.domain.repository.FortniteRepository
import javax.inject.Inject

class GetShopUseCase @Inject constructor(
    private val repository: FortniteRepository
) {
    suspend operator fun invoke(): List<ShopItem> {
        val shopData = repository.getShop()
        val entries = shopData.flatMap { it.entries }

        val undesiredNames = listOf("Jam Tracks", "Pistas de improvisación", "OtroNombre1", "OtroNombre2")
        val filteredEntries = entries.filter { entry ->
            val name = entry.layout?.name
            !undesiredNames.contains(name)
        }


        val groupedEntries = filteredEntries.groupBy { it.layout?.name ?: "Other" }
        val shopItems = mutableListOf<ShopItem>()

        groupedEntries.forEach { (name, entries) ->
            shopItems.add(ShopItem.HeaderItem(name))
            val sortedEntries = entries.sortedWith(compareByDescending<Entry> { it.bundle != null }
                .thenByDescending { it.sortPriority })
            sortedEntries.forEach { entry -> shopItems.add(ShopItem.EntryItem(entry)) }
        }

        return shopItems
    }
}

