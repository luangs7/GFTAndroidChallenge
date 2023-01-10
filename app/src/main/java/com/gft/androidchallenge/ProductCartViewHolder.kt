package com.gft.androidchallenge

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.bumptech.glide.signature.ObjectKey
import kotlinx.android.synthetic.main.item_product.view.*

class ProductCartViewHolder (
    itemView: View,
    private val onCheckedListener: (Product) -> Unit
) : RecyclerView.ViewHolder(itemView) {

    fun bind(item: Product) {
        itemView.name.text = item.name
        itemView.price.text = item.price.toCurrency()
        itemView.progressBar.visibility = View.VISIBLE
        Glide.with(itemView.context)
            .load(item.image)
            .signature(ObjectKey(System.currentTimeMillis().toString()))
            .listener(object: RequestListener<Drawable>{
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    itemView.progressBar.visibility = View.GONE
                    return true
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    itemView.progressBar.visibility = View.GONE
                    itemView.picture.setImageDrawable(resource)
                    return true
                }
            })
            .into(itemView.picture)

        itemView.checkbox.setOnCheckedChangeListener { _, _ -> onCheckedListener.invoke(item) }

    }
}