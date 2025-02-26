package com.lunatcoms.shopexplorer.presentation.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavArgs
import androidx.navigation.navArgs
import com.lunatcoms.shopexplorer.R
import com.lunatcoms.shopexplorer.databinding.ActivitySkinDetailBinding
import com.squareup.picasso.Picasso
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

        skinDetailViewModel.fetchDetailSkin(args.idSkin)
        skinDetailViewModel.detailSkin.observe(this, Observer { resource ->

            resource?.let {

                val featuredImage = it.data?.images?.featured
                val iconImage = it.data?.images?.icon
                val smallIconImage = it.data?.images?.smallIcon

                val imageUrl = featuredImage ?: iconImage ?: smallIconImage

                Picasso.get()
                    .load(imageUrl)
                    .into(binding.ivSkinDetail)
            }
        })



    }
}