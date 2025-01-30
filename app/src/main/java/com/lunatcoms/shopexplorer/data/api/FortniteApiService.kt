package com.lunatcoms.shopexplorer.data.api

import com.lunatcoms.shopexplorer.data.model.MapResponse
import com.lunatcoms.shopexplorer.data.model.ShopResponse
import com.lunatcoms.shopexplorer.data.model.SkinResponse
import retrofit2.Response
import retrofit2.http.GET

interface FortniteApiService {
    @GET("v2/cosmetics/br/")
    suspend fun getSkins(): Response<SkinResponse>
    @GET("v2/shop?language=es")
    suspend fun getShop(): Response<ShopResponse>
    @GET("v1/map")
    suspend fun getMap(): Response<MapResponse>
}