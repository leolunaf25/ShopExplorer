package com.lunatcoms.shopexplorer.data.repository

import android.util.Log
import com.lunatcoms.shopexplorer.data.api.FortniteApiService
import com.lunatcoms.shopexplorer.data.model.MapData
import com.lunatcoms.shopexplorer.data.model.MapImages
import com.lunatcoms.shopexplorer.data.model.ShopData
import com.lunatcoms.shopexplorer.data.model.SkinData
import com.lunatcoms.shopexplorer.data.model.SkinDetailData
import com.lunatcoms.shopexplorer.data.model.SkinDetailResponse
import com.lunatcoms.shopexplorer.domain.repository.FortniteRepository
import java.lang.Exception
import javax.inject.Inject

class FortniteRepositoryImpl @Inject constructor(
    private val apiService: FortniteApiService
) : FortniteRepository{
    override suspend fun getSkins(): List<SkinData> {
        val response = apiService.getSkins()
        if (response.isSuccessful){
            return response.body()?.data ?: emptyList()
        } else{
            throw Exception("Error: ${response.code()} - ${response.message()}")
        }
    }

    override suspend fun getDetailSkin(idSkin:String): SkinDetailResponse {
        return apiService.getDetailSkin(idSkin).body()!!
    }

    override suspend fun getShop(): List<ShopData> {
        val response = apiService.getShop()
        if (response.isSuccessful){
            val shopResponse = response.body()
            return shopResponse?.data?.let { listOf(it) } ?: emptyList()
        } else {
            throw Exception("Error: ${response.code()} - ${response.message()}")
        }
    }

    override suspend fun getMap(): MapImages {
        val response = apiService.getMap()

        if (response.isSuccessful){
            return response.body()?.data?.images ?: MapImages("No valida","No valida")
        }else{
            throw Exception("Error: ${response.code()} - ${response.message()}")
        }
    }
}