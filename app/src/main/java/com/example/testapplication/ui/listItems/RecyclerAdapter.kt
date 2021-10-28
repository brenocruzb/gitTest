package com.example.testapplication.ui.listItems

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testapplication.R
import com.example.testapplication.data.model.Cat
import kotlinx.android.synthetic.main.card_layout.view.*

class RecyclerAdapter(private val list: List<Cat>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        val context = holder.itemView.context
        holder.itemDetail.text = list[position].text
        holder.itemTitle.text = context.getString(R.string.fact_title)
        holder.itemImage.setImageResource(R.drawable.image)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemImage: ImageView = itemView.item_image
        val itemTitle: TextView = itemView.item_title
        val itemDetail: TextView = itemView.item_detail
    }
}