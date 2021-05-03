package com.example.fetchmoviesdemo.helper

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.fetchmoviesdemo.model.MovieItem

@BindingAdapter("showTitle")
fun TextView.setShowTitle(item:MovieItem){
    text = item.Title;
}

@BindingAdapter("showYear")
fun TextView.setShowYear(item:MovieItem){
    text = item.Year;
}
