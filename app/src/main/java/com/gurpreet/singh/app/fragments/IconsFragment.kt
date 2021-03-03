package com.gurpreet.singh.app.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.gurpreet.singh.app.R
import com.gurpreet.singh.app.databinding.FragmentIconsBinding


class IconsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentIconsBinding
                = DataBindingUtil.inflate(inflater, R.layout.fragment_icons, container, false)

        return binding.root
    }
}