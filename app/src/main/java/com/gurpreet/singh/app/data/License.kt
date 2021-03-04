package com.gurpreet.singh.app.data

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class License (
    val scope: String,

    @Json(name = "license_id")
    val licenseID: Long?,
    val name: String?,
    val url: String?
): Parcelable