package com.lunatcoms.shopexplorer.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lunatcoms.shopexplorer.R
import com.lunatcoms.shopexplorer.data.model.Entry
import com.lunatcoms.shopexplorer.data.model.ShopData
import com.lunatcoms.shopexplorer.domain.model.ShopItem

// ShopAdapter.kt

class ShopAdapter(
    private var items: List<ShopItem> = emptyList()
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    fun updateList(list: List<ShopItem>) {
        items = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return if (viewType == ITEM_TYPE_ENTRY) {
            val view = layoutInflater.inflate(R.layout.item_shop, parent, false)
            ShopViewHolder(view)
        } else {
            val view = layoutInflater.inflate(R.layout.item_header, parent, false)
            HeaderViewHolder(view)
        }
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ShopViewHolder -> holder.bind((items[position] as ShopItem.EntryItem).entry)
            is HeaderViewHolder -> holder.bind((items[position] as ShopItem.HeaderItem).header)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is ShopItem.EntryItem -> ITEM_TYPE_ENTRY
            is ShopItem.HeaderItem -> ITEM_TYPE_HEADER
        }
    }

    companion object {
        private const val ITEM_TYPE_ENTRY = 0
        private const val ITEM_TYPE_HEADER = 1
    }
}

