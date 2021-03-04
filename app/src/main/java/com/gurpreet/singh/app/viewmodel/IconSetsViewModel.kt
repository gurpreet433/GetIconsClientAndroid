package com.gurpreet.singh.app.viewmodel

import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gurpreet.singh.app.data.Iconset
import com.gurpreet.singh.app.network.IconsApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class IconSetsViewModel : ViewModel() {
    var isLoading = true
    var lastId : String = ""
    val itemPerPage: String = "20"

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    var iconSetList = MutableLiveData<List<Iconset>>()

    init {
        getIconsData( itemPerPage, "")
    }

    fun getIconsData(count: String, afterId: String) {
        val map = mapOf(
            "count" to count,
            "after" to afterId
        )
        var resultStatus = ""
        coroutineScope.launch {

            var getServerResponseDeferred = IconsApi.retrofitService.getIconSets(map)

            try {
                var serverResponse = getServerResponseDeferred.await()

                lastId = serverResponse.iconsets?.get(serverResponse.iconsets!!.lastIndex)?.iconsetID.toString()

                var oldList: List<Iconset>? = iconSetList.value
                var newList: List<Iconset>? = serverResponse.iconsets
                iconSetList.value = concatenate(oldList, newList)
                resultStatus = "Success" + serverResponse.iconsets
            } catch (t: Throwable) {
                resultStatus = "Failure" + t.message
            }

            Log.i("apiresponse", resultStatus + "")
        }


    }

    fun concatenate(vararg lists: List<Iconset>?): List<Iconset>? {
        val result: MutableList<Iconset>? = ArrayList()
        for (list in lists) {
            if (list != null) {
                result?.addAll(list)
            }
        }
        return result
    }
}