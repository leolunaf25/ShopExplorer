package com.lunatcoms.shopexplorer.domain.repository

import com.lunatcoms.shopexplorer.data.model.MapImages
import com.lunatcoms.shopexplorer.data.model.ShopData
import com.lunatcoms.shopexplorer.data.model.SkinData
import com.lunatcoms.shopexplorer.data.model.SkinDetailData
import com.lunatcoms.shopexplorer.data.model.SkinDetailResponse

interface FortniteRepository {
    suspend fun getSkins(): List<SkinData>
    suspend fun getDetailSkin(idSkin: String): SkinDetailResponse
    suspend fun getShop(): List<ShopData>
    suspend fun getMap(): MapImages
}