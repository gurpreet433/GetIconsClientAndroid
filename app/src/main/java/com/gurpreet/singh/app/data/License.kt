package com.gurpreet.singh.app.data

import com.squareup.moshi.Json

data class License (
    val scope: String,

    @Json(name = "license_id")
    val licenseID: Long,
    val name: String,
    val url: String
)