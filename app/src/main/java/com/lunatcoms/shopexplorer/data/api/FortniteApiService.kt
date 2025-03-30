package com.lunatcoms.shopexplorer.data.api

import com.lunatcoms.shopexplorer.data.model.MapResponse
import com.lunatcoms.shopexplorer.data.model.ShopResponse
import com.lunatcoms.shopexplorer.data.model.SkinDetailResponse
import com.lunatcoms.shopexplorer.data.model.SkinResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface FortniteApiService {
    @GET("v2/cosmetics/br?language=es-419")
    suspend fun getSkins(): Response<SkinResponse>

    @GET("v2/cosmetics/br/{idSkin}?language=es-419")
    suspend fun getDetailSkin(@Path("idSkin") idSkin:String): Response<SkinDetailResponse>

    @GET("v2/shop?language=es-419")
    suspend fun getShop(): Response<ShopResponse>
    @GET("v1/map")
    suspend fun getMap(): Response<MapResponse>
}