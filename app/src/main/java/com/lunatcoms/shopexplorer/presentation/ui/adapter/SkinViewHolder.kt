package com.lunatcoms.shopexplorer.presentation.ui.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.lunatcoms.shopexplorer.data.model.SkinData
import com.lunatcoms.shopexplorer.databinding.ItemSkinBinding
import com.squareup.picasso.Picasso

class SkinViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemSkinBinding.bind(view)
    fun bind(skin: SkinData){

        if (skin.type.value == "outfit"){
            Picasso.get()
                .load(skin.images.icon)
                .into(binding.ivSkin)
            binding.tvSkinName.text = skin.name
        }
    }
}