package com.lunatcoms.shopexplorer.presentation.ui.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.lunatcoms.shopexplorer.data.model.Entry
import com.lunatcoms.shopexplorer.databinding.ItemShopBinding
import com.squareup.picasso.Picasso

// ShopViewHolder.kt

class ShopViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemShopBinding.bind(view)

    fun bind(entry: Entry) {
        binding.tvItemPrice.text = entry.finalPrice.toString()

        // Cargar imagen del vbuck
        Picasso.get()
            .load("https://fortnite-api.com/images/vbuck.png")
            .into(binding.ivIconBuck)

        // Verificar si el bundle no es nulo y cargar la imagen del bundle
        if (entry.bundle != null) {
            binding.tvItemName.text = entry.bundle.name
            Picasso.get().load(entry.bundle.image).into(binding.ivItem)
        } else {
            // Verificar si hay imágenes en brItems
            val brItemsNames = entry.brItems?.mapNotNull { it.name }?.firstOrNull() ?: "No items"
            binding.tvItemName.text = brItemsNames

            val urlImage = entry.brItems?.firstOrNull()?.images?.featured
                ?: entry.newDisplayAsset?.renderImages?.firstOrNull()?.image
                ?: "https://fortnite-api.com/images/vbuck.png"

            Picasso.get().load(urlImage).into(binding.ivItem)
        }
    }
}
