package com.gft.androidchallenge

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class ProductCartAdapter(
    private val onCheckedListener: (Product) -> Unit
) : RecyclerView.Adapter<ProductCartViewHolder>() {

    var users = emptyList<Product>()
        set(value) {
            val result = DiffUtil.calculateDiff(
                ProductCartDiffCallback(
                    field,
                    value
                )
            )
            result.dispatchUpdatesTo(this)
            field = value
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductCartViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product, parent, false)

        return ProductCartViewHolder(view, onCheckedListener)
    }

    override fun onBindViewHolder(holder: ProductCartViewHolder, position: Int) {
        holder.bind(users[position])
    }

    override fun getItemCount(): Int = users.size
}