package com.gurpreet.singh.app.data

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class Iconset (
    @Json(name = "are_all_icons_glyph")
    val areAllIconsGlyph: Boolean?,

    val author: Author?,
    val styles:  @RawValue List<Any?>?,
    val name: String?,
    val prices: List<Price>?,

    @Json(name = "iconset_id")
    val iconsetID: Long?,

    @Json(name = "icons_count")
    val iconsCount: Long?,

    val identifier: String?,

    @Json(name = "published_at")
    val publishedAt: String?,

    @Json(name = "is_premium")
    val isPremium: Boolean?,

    val categories:  @RawValue List<Any?>?,
    val type: String?
):Parcelable