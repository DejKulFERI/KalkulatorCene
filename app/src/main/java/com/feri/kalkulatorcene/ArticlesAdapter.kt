package com.feri.kalkulatorcene

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ArticlesAdapter(private val mList: MutableList<ArticlesViewModel>) :
    RecyclerView.Adapter<ArticlesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemsViewModel = mList[position]
        holder.imgCardItem.setImageResource(itemsViewModel.image)
        holder.tvName.text = itemsViewModel.name.toString()
        holder.tvPricePerKg.text = itemsViewModel.price.toString()
    }

    class ViewHolder(
        ItemView: View

    ) : RecyclerView.ViewHolder(ItemView) {
        val imgCardItem: ImageView = itemView.findViewById(R.id.imgCardItem)
        val tvName: TextView = itemView.findViewById(R.id.tvName)
        val tvPricePerKg: TextView = itemView.findViewById(R.id.tvPricePerKg)
    }

    override fun getItemCount(): Int {
        return mList.size
    }
}