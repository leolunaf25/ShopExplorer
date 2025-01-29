package com.lunatcoms.shopexplorer.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lunatcoms.shopexplorer.R
import com.lunatcoms.shopexplorer.data.model.Entry
import com.lunatcoms.shopexplorer.data.model.ShopData

class ShopAdapter(
    private var shops: List<ShopData>
) : RecyclerView.Adapter<ShopViewHolder>() {

    private var entries: List<Entry> = shops.flatMap { it.entries }

    fun updateList(list: List<ShopData>) {
        shops = list
        entries = shops.flatMap { it.entries }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ShopViewHolder(layoutInflater.inflate(R.layout.item_shop, parent, false))
    }

    override fun getItemCount(): Int = entries.size

    override fun onBindViewHolder(holder: ShopViewHolder, position: Int) {
        holder.bind(entries[position])
    }
}
