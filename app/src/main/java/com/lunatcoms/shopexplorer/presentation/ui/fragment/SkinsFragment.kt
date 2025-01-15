package com.lunatcoms.shopexplorer.presentation.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lunatcoms.shopexplorer.databinding.FragmentSkinsBinding

class SkinsFragment : Fragment() {

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