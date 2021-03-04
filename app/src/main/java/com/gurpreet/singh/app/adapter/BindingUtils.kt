package com.gurpreet.singh.app.adapter

import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.gurpreet.singh.app.R
import com.gurpreet.singh.app.data.Iconset


@BindingAdapter("priceFormatted")
fun TextView.setPriceFormatted(item: Iconset?) {
    item?.let {
        text = item.prices[0].price.toString()
    }
}

@BindingAdapter("licenceNameFormatted")
fun TextView.setLicenceNameFormatted(item: Iconset?) {
    item?.let {
        text = item.prices[0].license.name
    }
}

@BindingAdapter("premiumOrFreeBadge")
fun ImageView.setPremiumOrFreeBadge(item: Iconset?) {
    item?.let {
        setImageResource(
            when (item.isPremium) {
                true -> R.drawable.ic_launcher_background
                false -> R.drawable.ic_launcher_foreground
            })
    }
}

