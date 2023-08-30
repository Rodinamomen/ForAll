package com.example.forall.Home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.forall.Database.Product
import com.example.forall.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class homeAdapter(val data : List<Product> ) :RecyclerView.Adapter<homeAdapter.myHolder>() {

    class myHolder(val row: View): RecyclerView.ViewHolder(row){
        var productName = row.findViewById<TextView>(R.id.productname_txtview)
        var productimage = row.findViewById<ImageView>(R.id.productimage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myHolder {
        val row = LayoutInflater.from(parent.context).inflate(R.layout.random_meals_item_layout,parent, false)
        return myHolder(row)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: myHolder, position: Int) {
        holder.productName.text= data[position].title
         Glide.with(holder.itemView.context)
            .load(data[position].thumbnail)
            .centerCrop()
            .into(holder.productimage)
    }

}