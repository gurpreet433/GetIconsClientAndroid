package com.gurpreet.singh.app.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.gurpreet.singh.app.R
import com.gurpreet.singh.app.data.ServerResponse
import com.gurpreet.singh.app.databinding.FragmentIconSetsBinding
import com.gurpreet.singh.app.network.IconsApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class IconSetsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val binding: FragmentIconSetsBinding
            = DataBindingUtil.inflate(inflater, R.layout.fragment_icon_sets, container, false)
        getIconsData("2")
        return binding.root
    }

    private fun getIconsData(count: String){
         val map = mapOf("count" to count)

        IconsApi.retrofitService.getIconSets(map).enqueue(object: Callback<ServerResponse>{
            override fun onResponse(call: Call<ServerResponse>, response: Response<ServerResponse>) {
                if(!response.isSuccessful){
                    Log.i("apiresponse", "Failuree " + response.body())
                }else{
                    Log.i("apiresponse", "Success " + response.body())
                }

            }

            override fun onFailure(call: Call<ServerResponse>, t: Throwable) {
                Log.i("apiresponse", "Failure " + t.message)
            }
        })
    }
}