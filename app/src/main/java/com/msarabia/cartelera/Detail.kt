package com.msarabia.cartelera

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.msarabia.cartelera.data.models.MediaInfo
import com.msarabia.cartelera.databinding.ActivityDetailBinding

class Detail : AppCompatActivity() {
    lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        binding.lifecycleOwner = this

        //Get Arguments
        val vinfo = intent.getParcelableExtra<MediaInfo>("info")

        if (vinfo!=null){
            binding.info = vinfo
            binding.imgSize ="w780"
        }

    }
}