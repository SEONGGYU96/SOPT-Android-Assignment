package com.gyugyu.loginandjoinwithretrofit.ui.main.adapter.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gyugyu.loginandjoinwithretrofit.R
import com.gyugyu.loginandjoinwithretrofit.ui.main.model.InstaData

class InstaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val text_username = itemView.findViewById<TextView>(R.id.text_username)
    val img_profile = itemView.findViewById<ImageView>(R.id.img_profile)
    val img_contents = itemView.findViewById<ImageView>(R.id.img_contents)

    fun bind(instaData: InstaData) {
        text_username.text = instaData.userName
        Glide.with(itemView).load(instaData.img_profile).into(img_profile)
        Glide.with(itemView).load(instaData.img_contents).into(img_contents)
    }
}