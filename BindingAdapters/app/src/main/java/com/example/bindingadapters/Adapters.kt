package com.example.bindingadapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
//import com.squareup.picasso.Picasso

//@BindingAdapter("imageUrl")
//fun ImageView.imageUrl(url: String?) {
// //if (!url.isNullOrEmpty()) {
//  Glide.with(this.context).load(url).into(this)
// //}
//}
@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, url: String?) {
  Glide.with(view.context)
    .load(url)
    .into(view)
}