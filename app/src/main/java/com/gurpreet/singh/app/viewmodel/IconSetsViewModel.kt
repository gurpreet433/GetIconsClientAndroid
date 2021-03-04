package com.gurpreet.singh.app.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gurpreet.singh.app.data.Iconset
import com.gurpreet.singh.app.network.IconsApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class IconSetsViewModel : ViewModel() {
    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    var iconSetList = MutableLiveData <List<Iconset>>()

    init {
        getIconsData("2")
    }

    private fun getIconsData(count: String){
        val map = mapOf("count" to count)
        var resultStatus = ""
        coroutineScope.launch {

            var getServerResponseDeferred = IconsApi.retrofitService.getIconSets(map)

            try {
                var serverResponse = getServerResponseDeferred.await()
                iconSetList.value = serverResponse.iconsets
                resultStatus = "Success" + serverResponse.iconsets
            }catch (t: Throwable){
                resultStatus= "Failure" + t.message
            }

            Log.i("apiresponse", resultStatus + "")
        }
    }
}