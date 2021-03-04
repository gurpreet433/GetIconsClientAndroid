package com.gurpreet.singh.app.adapter

import android.widget.TextView
import androidx.databinding.BindingAdapter
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
