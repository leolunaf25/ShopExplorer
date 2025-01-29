package com.lunatcoms.shopexplorer.presentation.ui.adapter

import android.provider.Settings.System.getString
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.lunatcoms.shopexplorer.R
import com.lunatcoms.shopexplorer.data.model.Entry
import com.lunatcoms.shopexplorer.databinding.ItemShopBinding
import com.squareup.picasso.Picasso

class ShopViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemShopBinding.bind(view)
    fun bind(entry: Entry) {
        binding.tvItemPrice.text = entry.finalPrice.toString()

        Picasso.get()
            .load("https://fortnite-api.com/images/vbuck.png")
            .into(binding.ivIconBuck)
        // Verificar si el bundle no es nulo
        if (entry.bundle != null) {
            binding.tvItemName.text = entry.bundle.name

            Picasso.get()
                .load(entry.bundle.image)
                .into(binding.ivItem)
        } else {
            // Concatenar los nombres de los brItems si no hay bundle
            val brItemsNames = entry.brItems?.mapNotNull { it.name }?.firstOrNull() ?: "No items"
            binding.tvItemName.text = brItemsNames

            // Obtener la primera URL de imagen válida si no hay bundle
            val urlImage = entry.brItems?.mapNotNull { it.images.featured }?.firstOrNull() ?: "https://fortnite-api.com/images/vbuck.png"
            Picasso.get()
                .load(urlImage)
                .into(binding.ivItem)
        }
    }



}
