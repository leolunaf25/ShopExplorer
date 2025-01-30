package com.lunatcoms.shopexplorer.data.model

import com.google.gson.annotations.SerializedName

data class MapResponse(
    @SerializedName("status") val status: Int,
    @SerializedName("data") val data: MapData
)

data class MapData(
    @SerializedName("images") val images: MapImages
)

data class MapImages(
    @SerializedName("blank") val blank: String,
    @SerializedName("pois") val points: String
)