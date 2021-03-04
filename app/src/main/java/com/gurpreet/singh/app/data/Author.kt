package com.gurpreet.singh.app.data

import com.squareup.moshi.Json

data class Author (
    val username: String?,
    val name: String?,

    @Json(name = "iconsets_count")
    val iconsetsCount: Long?,
    @Json(name = "is_designer")
    val isDesigner: Boolean?,
    val company: String? = null,
    @Json(name = "user_id")
    val userID: Long?
)