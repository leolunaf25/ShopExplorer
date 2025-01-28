package com.lunatcoms.shopexplorer.data.model

import com.google.gson.annotations.SerializedName

data class SkinResponse(
    @SerializedName("status") val status: Int,
    @SerializedName("data") val data: List<SkinData>
)

data class SkinData(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("type") val type: TypeData,
    @SerializedName("rarity") val rarity: RarityData,
    @SerializedName("set") val set: SetData,
    @SerializedName("introduction") val introduction: IntroductionData,
    @SerializedName("images") val images: SkinImages,
    @SerializedName("showcaseVideo") val showcaseVideo: String?,
    @SerializedName("dynamicPakId") val dynamicPakId: String,
    @SerializedName("added") val added: String
)

data class SkinImages(
    @SerializedName("smallIcon") val smallIcon: String,
    @SerializedName("icon") val icon: String,
    @SerializedName("featured") val featured: String
)

data class TypeData(
    @SerializedName("value") val value: String,
    @SerializedName("displayValue") val displayValue: String,
    @SerializedName("backendValue") val backendValue: String
)

data class RarityData(
    @SerializedName("value") val value: String,
    @SerializedName("displayValue") val displayValue: String,
    @SerializedName("backendValue") val backendValue: String
)

data class SetData(
    @SerializedName("value") val value: String,
    @SerializedName("text") val text: String,
    @SerializedName("backendValue") val backendValue: String
)

data class IntroductionData(
    @SerializedName("chapter") val chapter: String,
    @SerializedName("season") val season: String,
    @SerializedName("text") val text: String,
    @SerializedName("backendValue") val backendValue: Int
)
