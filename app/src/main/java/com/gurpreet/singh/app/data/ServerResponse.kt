package com.gurpreet.singh.app.data

import com.squareup.moshi.Json

data class ServerResponse (
    @Json(name = "total_count")
    val totalCount: Long,

    val iconsets: List<Iconset>
)

data class Iconset (
    @Json(name = "are_all_icons_glyph")
    val areAllIconsGlyph: Boolean,

    val author: Author,
    val styles: List<Any?>,
    val name: String,
    val prices: List<Price>,

    @Json(name = "iconset_id")
    val iconsetID: Long,

    @Json(name = "icons_count")
    val iconsCount: Long,

    val identifier: String,

    @Json(name = "published_at")
    val publishedAt: String,

    @Json(name = "is_premium")
    val isPremium: Boolean,

    val categories: List<Any?>,
    val type: String
)

data class Author (
    val username: String,
    val name: String,

    @Json(name = "iconsets_count")
    val iconsetsCount: Long,

    @Json(name = "is_designer")
    val isDesigner: Boolean,

    val company: String? = null,

    @Json(name = "user_id")
    val userID: Long
)

data class Price (
    val currency: String,
    val license: License,
    val price: Double
)

data class License (
    val scope: String,

    @Json(name = "license_id")
    val licenseID: Long,

    val name: String,
    val url: String
)
