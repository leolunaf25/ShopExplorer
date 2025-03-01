package com.lunatcoms.shopexplorer.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.lunatcoms.shopexplorer.databinding.FragmentStoreBinding
import com.lunatcoms.shopexplorer.presentation.ui.adapter.ShopAdapter
import com.lunatcoms.shopexplorer.presentation.viewmodel.ShopViewModel
import dagger.hilt.android.AndroidEntryPoint

// StoreFragment.kt

@AndroidEntryPoint
class StoreFragment : Fragment() {

    private val shopViewModel by viewModels<ShopViewModel>()

    private var _binding: FragmentStoreBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: ShopAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()
    }

    private fun initUI() {
        initShop()
    }

    private fun initShop() {

        adapter = ShopAdapter(emptyList())

        val gridLayoutManagerIn = GridLayoutManager(context,2)
        gridLayoutManagerIn.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup(){
            override fun getSpanSize(position: Int): Int {
                return when (adapter.getItemViewType(position)){
                    ShopAdapter.ITEM_TYPE_HEADER -> 2
                    ShopAdapter.ITEM_TYPE_ENTRY -> 1
                    else -> 1
                }
            }
        }
        binding.rvShop.layoutManager = gridLayoutManagerIn
        binding.rvShop.adapter = adapter

        shopViewModel.shops.observe(viewLifecycleOwner) { shops ->
            shops?.let {
                adapter.updateList(it)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStoreBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
