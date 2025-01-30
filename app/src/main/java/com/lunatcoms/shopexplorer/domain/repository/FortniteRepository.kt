package com.lunatcoms.shopexplorer.domain.repository

import com.lunatcoms.shopexplorer.data.model.MapImages
import com.lunatcoms.shopexplorer.data.model.ShopData
import com.lunatcoms.shopexplorer.data.model.SkinData

interface FortniteRepository {
    suspend fun getSkins(): List<SkinData>
    suspend fun getShop(): List<ShopData>
    suspend fun getMap(): MapImages
}