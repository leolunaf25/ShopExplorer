package com.lunatcoms.shopexplorer.data.model

import com.google.gson.annotations.SerializedName

data class SkinDetailResponse(
    @SerializedName("status") val status: Int,
    @SerializedName("data") val data: SkinDetailData
)

data class SkinDetailData(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("type") val type: Type,
    @SerializedName("rarity") val rarity: Rarity,
    @SerializedName("set") val set: Set,
    @SerializedName("introduction") val introduction: Introduction,
    @SerializedName("images") val images: ImageSkin,
    @SerializedName("variants") val variants: List<VariantSkin>,
    @SerializedName("builtInEmoteIds") val builtInEmoteIds: List<String>,
    @SerializedName("metaTags") val metaTags: List<String>,
    @SerializedName("showcaseVideo") val showcaseVideo: String,
    @SerializedName("added") val added: String
)

data class Type(
    @SerializedName("value") val value: String,
    @SerializedName("displayValue") val displayValue: String,
    @SerializedName("backendValue") val backendValue: String
)

data class Rarity(
    @SerializedName("value") val value: String,
    @SerializedName("displayValue") val displayValue: String,
    @SerializedName("backendValue") val backendValue: String
)

data class Set(
    @SerializedName("value") val value: String,
    @SerializedName("text") val text: String,
    @SerializedName("backendValue") val backendValue: String
)

data class Introduction(
    @SerializedName("chapter") val chapter: String,
    @SerializedName("season") val season: String,
    @SerializedName("text") val text: String,
    @SerializedName("backendValue") val backendValue: Int
)

data class ImageSkin(
    @SerializedName("smallIcon") val smallIcon: String,
    @SerializedName("icon") val icon: String,
    @SerializedName("featured") val featured: String
)

data class VariantSkin(
    @SerializedName("channel") val channel: String,
    @SerializedName("type") val type: String,
    @SerializedName("options") val options: List<Option>
)

data class Option(
    @SerializedName("tag") val tag: String,
    @SerializedName("name") val name: String,
    @SerializedName("image") val image: String
)
