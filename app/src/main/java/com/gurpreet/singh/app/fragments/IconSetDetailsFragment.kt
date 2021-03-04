package com.gurpreet.singh.app.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.gurpreet.singh.app.R
import com.gurpreet.singh.app.data.Iconset

class IconSetDetailsFragment : Fragment() {
    private val args: IconSetDetailsFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val iconSet: Iconset = args.iconSet

        Log.i("hello", iconSet.toString())

        return inflater.inflate(R.layout.fragment_icon_set_details, container, false)
    }
}