package com.lunatcoms.shopexplorer.domain.model

import com.lunatcoms.shopexplorer.data.model.Entry

sealed class ShopItem {
    data class EntryItem(val entry: Entry) : ShopItem()
    data class HeaderItem(val header: String) : ShopItem()
}
