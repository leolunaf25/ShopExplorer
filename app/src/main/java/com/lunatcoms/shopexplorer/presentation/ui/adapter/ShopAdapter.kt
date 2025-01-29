package com.lunatcoms.shopexplorer.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lunatcoms.shopexplorer.R
import com.lunatcoms.shopexplorer.data.model.Entry
import com.lunatcoms.shopexplorer.data.model.ShopData

class ShopAdapter(
    private var shops: List<Entry> = emptyList()
) : RecyclerView.Adapter<ShopViewHolder>() {

    fun updateList(list: List<Entry>) {
        shops = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ShopViewHolder(layoutInflater.inflate(R.layout.item_shop, parent, false))
    }

    override fun getItemCount(): Int = shops.size

    override fun onBindViewHolder(holder: ShopViewHolder, position: Int) {
        holder.bind(shops[position])
    }
}
