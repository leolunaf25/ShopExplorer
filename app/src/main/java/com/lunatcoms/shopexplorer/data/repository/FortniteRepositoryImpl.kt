package com.lunatcoms.shopexplorer.data.repository

import com.lunatcoms.shopexplorer.data.api.FortniteApiService
import com.lunatcoms.shopexplorer.data.model.SkinData
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
}