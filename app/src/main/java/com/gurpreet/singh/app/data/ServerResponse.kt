package com.gurpreet.singh.app.data
import com.squareup.moshi.Json


data class ServerResponse (
    @Json(name = "total_count")
    val totalCount: Long?,

    val iconsets: List<Iconset>?
)
