package com.lunatcoms.shopexplorer.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lunatcoms.shopexplorer.R
import com.lunatcoms.shopexplorer.data.model.SkinData

class SkinAdapter(
    private var skins:List<SkinData>
) : RecyclerView.Adapter<SkinViewHolder>() {

    fun updateData(newSkins: List<SkinData>) {
        skins = newSkins
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SkinViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return SkinViewHolder(layoutInflater.inflate(R.layout.item_skin, parent, false))
    }
    override fun getItemCount(): Int = skins.size
    override fun onBindViewHolder(holder: SkinViewHolder, position: Int) {
        holder.bind(skins[position])
    }
}