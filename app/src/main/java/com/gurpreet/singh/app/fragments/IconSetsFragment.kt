package com.gurpreet.singh.app.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import com.gurpreet.singh.app.R
import com.gurpreet.singh.app.data.ServerResponse
import com.gurpreet.singh.app.databinding.FragmentIconSetsBinding
import com.gurpreet.singh.app.network.IconsApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class IconSetsFragment : Fragment() {

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main )

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
        var resultStatus = ""
        coroutineScope.launch {

            var getServerResponseDeferred = IconsApi.retrofitService.getIconSets(map)

            try {
                var serverResponse = getServerResponseDeferred.await()
                 resultStatus= "Success" + serverResponse.iconsets
            }catch (t: Throwable){
                resultStatus= "Failure" + t.message
            }

            Log.i("apiresponse", resultStatus + "")
        }
    }
}