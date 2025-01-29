package com.lunatcoms.shopexplorer.presentation.ui.adapter

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.lunatcoms.shopexplorer.data.model.Entry
import com.lunatcoms.shopexplorer.data.model.ShopData
import com.lunatcoms.shopexplorer.databinding.ItemShopBinding
import com.squareup.picasso.Picasso

class ShopViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemShopBinding.bind(view)

    fun bind(entry: Entry) {
        binding.tvItemName.text = entry.finalPrice.toString()
    }
}
