package com.lunatcoms.shopexplorer.presentation.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.NavArgs
import androidx.navigation.navArgs
import com.lunatcoms.shopexplorer.R
import com.lunatcoms.shopexplorer.databinding.ActivitySkinDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SkinDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySkinDetailBinding
    private val skinDetailViewModel:SkinDetailViewModel by viewModels()

    private val args:SkinDetailActivityArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySkinDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        args.idSkin 
    }
}