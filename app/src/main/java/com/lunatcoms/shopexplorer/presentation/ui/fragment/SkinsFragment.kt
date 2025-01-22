package com.lunatcoms.shopexplorer.presentation.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.lunatcoms.shopexplorer.databinding.FragmentSkinsBinding
import com.lunatcoms.shopexplorer.presentation.viewmodel.SkinsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SkinsFragment : Fragment() {

    private val skinsViewModel by viewModels<SkinsViewModel>()

    private var _binding: FragmentSkinsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSkinsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

}