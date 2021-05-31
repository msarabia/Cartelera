package com.msarabia.cartelera.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.msarabia.cartelera.Detail
import com.msarabia.cartelera.R
import com.msarabia.cartelera.data.models.MediaInfo
import com.msarabia.cartelera.databinding.FragmentListVideoBinding
import com.msarabia.cartelera.helpers.Poster

class ListVideoFragment(val type: String, val category: String) : Fragment() {
    constructor() : this("", "")

    lateinit var binding: FragmentListVideoBinding
    private val viewmodel: ListVideoViewModel by viewModels {
        ListVideoViewModelFactory(
            type,
            category
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list_video, container, false)
        binding.lifecycleOwner = this.viewLifecycleOwner
        binding.sectionTitle.text = category
        setObservables()
        return binding.root
    }

    private fun setObservables() {
        viewmodel.listVideosItems.observe(viewLifecycleOwner) { listMedia ->
            binding.container.isVisible = true
            binding.loader.isVisible=false
            binding.listVideo.adapter =
                VideoAdapter(listMedia.results,R.layout.video_item,Poster.getImageSizeByCategory(category)) {
                    if (it is MediaInfo) {
                        val info = it
                        Log.d("ITEMCLIC", it.id.toString())
                        val detailIntent = Intent(requireContext(),Detail::class.java)
                        detailIntent.putExtra("info",info)
                        startActivity(detailIntent)
                    }
                }
        }
    }

}
