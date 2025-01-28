package com.lunatcoms.shopexplorer.data.api

import com.lunatcoms.shopexplorer.data.model.SkinResponse
import retrofit2.Response
import retrofit2.http.GET

interface FortniteApiService {
    @GET("cosmetics/br")
    suspend fun getSkins(): Response<SkinResponse>
}