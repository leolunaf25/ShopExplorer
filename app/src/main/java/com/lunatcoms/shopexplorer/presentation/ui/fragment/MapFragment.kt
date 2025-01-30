package com.lunatcoms.shopexplorer.presentation.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.lunatcoms.shopexplorer.data.model.MapData
import com.lunatcoms.shopexplorer.data.model.MapImages
import com.lunatcoms.shopexplorer.databinding.FragmentMapBinding
import com.lunatcoms.shopexplorer.domain.usecase.GetMapUseCase
import com.lunatcoms.shopexplorer.presentation.viewmodel.MapViewModel
import com.squareup.picasso.Picasso

import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MapFragment : Fragment() {

    private val mapViewModel by viewModels<MapViewModel>()

    private var _binding: FragmentMapBinding? = null
    private val binding get() = _binding!!

    private lateinit var mapNormal: String
    private lateinit var mapPoint: String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()
    }

    private fun initUI() {

        mapViewModel.maps.observe(viewLifecycleOwner) { maps ->

            mapNormal = maps.blank
            mapPoint = maps.points

            initImage(mapNormal,mapPoint)
        }

    }

    private fun initImage(mapNormal: String, mapPoint: String) {
        Picasso.get().load(mapPoint).into(binding.ivMap)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMapBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}