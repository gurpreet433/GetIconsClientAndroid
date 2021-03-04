package com.gurpreet.singh.app.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Price (
    val currency: String?,
    val license: License?,
    val price: Double?
): Parcelable