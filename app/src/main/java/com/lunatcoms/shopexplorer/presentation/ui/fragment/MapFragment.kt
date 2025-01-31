package com.lunatcoms.shopexplorer.presentation.ui.fragment

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.lunatcoms.shopexplorer.databinding.FragmentMapBinding
import com.lunatcoms.shopexplorer.presentation.viewmodel.MapViewModel
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import java.lang.Exception

@AndroidEntryPoint
class MapFragment : Fragment() {

    private val mapViewModel by viewModels<MapViewModel>()

    private var _binding: FragmentMapBinding? = null
    private val binding get() = _binding!!

    private lateinit var mapNormalImage: Bitmap
    private lateinit var mapPointImage: Bitmap

    private val picassoTargets = mutableListOf<com.squareup.picasso.Target>()

    private var isSwitchChecked = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMapBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (savedInstanceState != null) {
            isSwitchChecked = savedInstanceState.getBoolean("isSwitchChecked")
        }

        initUI()
    }

    private fun initUI() {
        mapViewModel.maps.observe(viewLifecycleOwner) { maps ->
            initImage(maps.blank, maps.points)
        }
    }

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private fun initImage(mapNormalUrl: String, mapPointUrl: String) {
        val switchMap = binding.swMap

        val targetNormal = object : com.squareup.picasso.Target {
            override fun onBitmapLoaded(bitmap: Bitmap, from: Picasso.LoadedFrom?) {
                mapNormalImage = bitmap
                if (!isSwitchChecked) {
                    binding.ivMap.setImageBitmap(mapNormalImage) // Set initial image
                }
            }

            override fun onBitmapFailed(e: Exception?, errorDrawable: Drawable?) {
                e?.printStackTrace()
            }

            override fun onPrepareLoad(placeHolderDrawable: Drawable?) {
            }
        }

        val targetPoint = object : com.squareup.picasso.Target {
            override fun onBitmapLoaded(bitmap: Bitmap, from: Picasso.LoadedFrom?) {
                mapPointImage = bitmap
                if (isSwitchChecked) {
                    binding.ivMap.setImageBitmap(mapPointImage) // Set initial image
                }
            }

            override fun onBitmapFailed(e: Exception?, errorDrawable: Drawable?) {
                e?.printStackTrace()
            }

            override fun onPrepareLoad(placeHolderDrawable: Drawable?) {
            }
        }
        picassoTargets.add(targetNormal)
        picassoTargets.add(targetPoint)

        Picasso.get().load(mapNormalUrl).into(targetNormal)
        Picasso.get().load(mapPointUrl).into(targetPoint)

        switchMap.isChecked = isSwitchChecked
        switchMap.setOnCheckedChangeListener { _, isChecked ->
            isSwitchChecked = isChecked
            if (isChecked) {
                binding.ivMap.setImageBitmap(mapPointImage)
            } else {
                binding.ivMap.setImageBitmap(mapNormalImage)
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean("isSwitchChecked", isSwitchChecked)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        picassoTargets.clear()
    }
}
