package com.lunatcoms.shopexplorer.presentation.ui.adapter

import android.view.View
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.lunatcoms.shopexplorer.data.model.SkinData
import com.lunatcoms.shopexplorer.databinding.ItemSkinBinding
import com.squareup.picasso.Picasso

class SkinViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemSkinBinding.bind(view)
    fun bind(skin: SkinData, onItemSelected: (SkinData) -> Unit) {

        val imageUrl = skin?.images?.icon ?: skin.images.smallIcon

        Picasso.get()
            .load(imageUrl)
            .into(binding.ivSkin)
        binding.tvSkinName.text = skin.name

        binding.parentSkin.setOnClickListener {
            startRotationAnimation(binding.ivSkin, newLambda = {onItemSelected(skin)})
            //onItemSelected(skin)
        }
    }

    private fun startRotationAnimation(view:View, newLambda:()->Unit){
        view.animate().apply {
            duration = 500
            interpolator = LinearInterpolator()
            rotationYBy(360f)
            withEndAction { newLambda() }
            start()
        }
    }
}