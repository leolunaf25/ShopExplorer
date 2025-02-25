package com.lunatcoms.shopexplorer.presentation.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.lunatcoms.shopexplorer.data.model.SkinData
import com.lunatcoms.shopexplorer.databinding.FragmentSkinsBinding
import com.lunatcoms.shopexplorer.presentation.ui.adapter.SkinAdapter
import com.lunatcoms.shopexplorer.presentation.viewmodel.SkinsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SkinsFragment : Fragment() {

    private val skinsViewModel by viewModels<SkinsViewModel>()

    private var _binding: FragmentSkinsBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: SkinAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()
    }

    private fun initUI() {
        initSkins()
        initSearchSkin()
    }

    private fun initSkins() {
        adapter = SkinAdapter(onItemSelected = {
            var idSkin:String = it.id
            findNavController().navigate(
                SkinsFragmentDirections.actionSkinsFragmentToSkinDetailActivity(idSkin)
            )
        })
        binding.rvSkin.layoutManager = GridLayoutManager(context,2)
        binding.rvSkin.adapter = adapter

        skinsViewModel.skins.observe(viewLifecycleOwner) { skins ->
            skins?.let {
                adapter.updateData(it)
            }
        }
    }

    private fun initSearchSkin() {
        binding.svSkin.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {
                    skinsViewModel.searchSkins(it)
                }

                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let {
                    skinsViewModel.searchSkins(it)
                }
                return true
            }

        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSkinsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}