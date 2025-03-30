package com.lunatcoms.shopexplorer.presentation.ui.detail

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.navigation.navArgs
import com.lunatcoms.shopexplorer.R
import com.lunatcoms.shopexplorer.databinding.ActivitySkinDetailBinding
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.Locale

@AndroidEntryPoint
class SkinDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySkinDetailBinding
    private val skinDetailViewModel: SkinDetailViewModel by viewModels()

    private val args: SkinDetailActivityArgs by navArgs()

    @SuppressLint("SetTextI18n")
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

                binding.tvNameDetail.text = it.data.name

                binding.tvDescriptionDetail.text = it.data.description

                binding.tvIntroductionDetail.text = it.data.introduction.text

                binding.tvRarityDetail.text = it.data.rarity.displayValue

                binding.tvDateDetail.text = getString(R.string.Date, formatDate(it.data.added))

            }

        })


    }

    private fun formatDate(inputDate: String): String {
        val inputFormat =
            SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
        val outputFormat = SimpleDateFormat(
            "dd 'de' MMMM 'de' yyyy",
            Locale("es", "ES")
        )
        val date = inputFormat.parse(inputDate)
        return outputFormat.format(date)
    }

}