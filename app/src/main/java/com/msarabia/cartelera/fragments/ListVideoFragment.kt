package com.msarabia.cartelera.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.msarabia.cartelera.R
import com.msarabia.cartelera.databinding.FragmentListVideoBinding

class ListVideoFragment(val type: Int) : Fragment() {
    lateinit var binding: FragmentListVideoBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list_video, container, false)
        return binding.root
    }
}
