package com.gurpreet.singh.app.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.gurpreet.singh.app.R
import com.gurpreet.singh.app.databinding.FragmentIconSetsBinding


class IconSetsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val binding: FragmentIconSetsBinding
            = DataBindingUtil.inflate(inflater, R.layout.fragment_icon_sets, container, false)

        return binding.root
    }
}