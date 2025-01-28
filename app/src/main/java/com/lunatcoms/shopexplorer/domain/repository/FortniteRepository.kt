package com.lunatcoms.shopexplorer.domain.repository

import com.lunatcoms.shopexplorer.data.model.SkinData

interface FortniteRepository {
    suspend fun getSkins(): List<SkinData>
}