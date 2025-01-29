package com.lunatcoms.shopexplorer.data.model

import com.google.gson.annotations.SerializedName

data class ShopResponse(
    @SerializedName("status") val status: Int,
    @SerializedName("data") val data: ShopData
)

data class ShopData(
    @SerializedName("hash") val hash: String,
    @SerializedName("date") val date: String,
    @SerializedName("vbuckIcon") val vbuckIcon: String,
    @SerializedName("entries") val entries: List<Entry>
)

data class Entry(
    @SerializedName("regularPrice") val regularPrice: Int,
    @SerializedName("finalPrice") val finalPrice: Int,
    @SerializedName("devName") val devName: String,
    @SerializedName("offerId") val offerId: String,
    @SerializedName("inDate") val inDate: String,
    @SerializedName("outDate") val outDate: String,
    @SerializedName("giftable") val giftable: Boolean,
    @SerializedName("refundable") val refundable: Boolean,
    @SerializedName("sortPriority") val sortPriority: Int,
    @SerializedName("layoutId") val layoutId: String?,
    @SerializedName("layout") val layout: Layout?,
    @SerializedName("tileSize") val tileSize: String,
    @SerializedName("newDisplayAssetPath") val newDisplayAssetPath: String?,
    @SerializedName("newDisplayAsset") val newDisplayAsset: NewDisplayAsset?,
    @SerializedName("brItems") val brItems: List<BrItem>?,
    @SerializedName("banner") val banner: Banner?,
    @SerializedName("bundle") val bundle: BundleData?,
    @SerializedName("cars") val cars: List<Car>?
)

data class Banner(
    @SerializedName("value") val value: String,
    @SerializedName("intensity") val intensity: String,
    @SerializedName("backendValue") val backendValue: String
)

data class Layout(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("category") val category: String?,
    @SerializedName("index") val index: Int,
    @SerializedName("rank") val rank: Int,
    @SerializedName("showIneligibleOffers") val showIneligibleOffers: String?,
    @SerializedName("useWidePreview") val useWidePreview: Boolean,
    @SerializedName("displayType") val displayType: String?
)

data class NewDisplayAsset(
    @SerializedName("id") val id: String?,
    @SerializedName("materialInstances") val materialInstances: List<MaterialInstance>?,
    @SerializedName("renderImages") val renderImages: List<RenderImage>?
)

data class MaterialInstance(
    @SerializedName("id") val id: String?,
    @SerializedName("primaryMode") val primaryMode: String?,
    @SerializedName("productTag") val productTag: String?,
    @SerializedName("images") val images: MaterialImages?,
    @SerializedName("colors") val colors: MaterialColors?,
    @SerializedName("flags") val flags: MaterialFlags?
)

data class MaterialImages(
    @SerializedName("CarTexture") val carTexture: String?,
    @SerializedName("ItemStackTexture") val itemStackTexture: String?,
    @SerializedName("Background") val background: String?
)

data class MaterialColors(
    @SerializedName("Background Color 1") val backgroundColor1: String?,
    @SerializedName("Floor Radial Angle") val floorRadialAngle: String?,
    @SerializedName("Floor Radial Offset") val floorRadialOffset: String?
)

data class MaterialFlags(
    @SerializedName("Use Utility Pass") val useUtilityPass: Boolean,
    @SerializedName("Display Car") val displayCar: Boolean,
    @SerializedName("Display Environment") val displayEnvironment: Boolean
)

data class RenderImage(
    @SerializedName("productTag") val productTag: String,
    @SerializedName("fileName") val fileName: String,
    @SerializedName("image") val image: String
)

data class BrItem(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("type") val type: TypeDat,
    @SerializedName("rarity") val rarity: RarityDat,
    @SerializedName("series") val series: SeriesData?,
    @SerializedName("set") val set: SetDat?,
    @SerializedName("introduction") val introduction: IntroductionDat?,
    @SerializedName("images") val images: Images,
    @SerializedName("variants") val variants: List<Variant>?,
    @SerializedName("showcaseVideo") val showcaseVideo: String?,
    @SerializedName("added") val added: String
)

data class TypeDat(
    @SerializedName("value") val value: String,
    @SerializedName("displayValue") val displayValue: String,
    @SerializedName("backendValue") val backendValue: String
)

data class RarityDat(
    @SerializedName("value") val value: String,
    @SerializedName("displayValue") val displayValue: String,
    @SerializedName("backendValue") val backendValue: String
)

data class SeriesData(
    @SerializedName("value") val value: String,
    @SerializedName("image") val image: String,
    @SerializedName("colors") val colors: List<String>,
    @SerializedName("backendValue") val backendValue: String
)

data class SetDat(
    @SerializedName("value") val value: String,
    @SerializedName("text") val text: String?,
    @SerializedName("backendValue") val backendValue: String
)

data class IntroductionDat(
    @SerializedName("chapter") val chapter: String,
    @SerializedName("season") val season: String,
    @SerializedName("text") val text: String?,
    @SerializedName("backendValue") val backendValue: Int
)

data class Images(
    @SerializedName("smallIcon") val smallIcon: String?,
    @SerializedName("icon") val icon: String,
    @SerializedName("featured") val featured: String?,
    @SerializedName("lego") val lego: LegoImages?,
    @SerializedName("bean") val bean: BeanImages?
)

data class LegoImages(
    @SerializedName("small") val small: String?,
    @SerializedName("large") val large: String?
)

data class BeanImages(
    @SerializedName("small") val small: String?,
    @SerializedName("large") val large: String?
)

data class Variant(
    @SerializedName("channel") val channel: String,
    @SerializedName("type") val type: String,
    @SerializedName("options") val options: List<VariantOption>
)

data class VariantOption(
    @SerializedName("tag") val tag: String,
    @SerializedName("name") val name: String,
    @SerializedName("image") val image: String?
)

data class BundleData(
    @SerializedName("name") val name: String,
    @SerializedName("info") val info: String,
    @SerializedName("image") val image: String
)

data class Car(
    @SerializedName("id") val id: String,
    @SerializedName("vehicleId") val vehicleId: String,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("type") val type: TypeData,
    @SerializedName("rarity") val rarity: RarityData,
    @SerializedName("images") val images: CarImages,
    @SerializedName("added") val added: String
)

data class CarImages(
    @SerializedName("small") val small: String?,
    @SerializedName("large") val large: String?
)
