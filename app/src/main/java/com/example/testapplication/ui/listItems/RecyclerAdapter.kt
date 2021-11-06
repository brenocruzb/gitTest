package com.example.testapplication.ui.listItems

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testapplication.R
import com.example.testapplication.entity.model.CatData
import kotlinx.android.synthetic.main.card_layout.view.*

class RecyclerAdapter(private val list: List<CatData>, private val listner: OnItemClickListener) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        with(holder) {
            val context = itemView.context
            itemDetail.text = list[position].fact
            itemTitle.text = context.getString(R.string.fact_title)
            itemImage.setImageResource(R.drawable.image)
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val itemImage: ImageView = itemView.item_image
        val itemTitle: TextView = itemView.item_title
        val itemDetail: TextView = itemView.item_detail

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            val position: Int = adapterPosition

            if (position != RecyclerView.NO_POSITION) {
                listner.onItemClick(position)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
}