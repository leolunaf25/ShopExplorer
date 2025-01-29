package com.lunatcoms.shopexplorer.presentation.ui.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lunatcoms.shopexplorer.R

// HeaderViewHolder.kt

class HeaderViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val headerTextView: TextView = view.findViewById(R.id.header_text_view)

    fun bind(header: String) {
        headerTextView.text = header
    }
}
