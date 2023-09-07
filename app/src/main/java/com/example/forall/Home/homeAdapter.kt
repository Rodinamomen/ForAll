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
import kotlin.math.floor
import kotlin.random.Random

class homeAdapter(val data : List<Product> ) :RecyclerView.Adapter<homeAdapter.myHolder>() {

    class myHolder(val row: View): RecyclerView.ViewHolder(row){
        var productName = row.findViewById<TextView>(R.id.productname_txtview)
        var productImage = row.findViewById<ImageView>(R.id.productimage)
        var saleText= row.findViewById<TextView>(R.id.sale_txtview)
        var productBrand = row.findViewById<TextView>(R.id.brand_textview)
        var star1 = row.findViewById<ImageView>(R.id.star1)
        var star2 = row.findViewById<ImageView>(R.id.star2)
        var star3 = row.findViewById<ImageView>(R.id.star3)
        var star4 = row.findViewById<ImageView>(R.id.star4)
        var star5 = row.findViewById<ImageView>(R.id.star5)
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
        holder.itemView.setClipToOutline(true)
         Glide.with(holder.itemView.context)
            .load(data[position].thumbnail)
            .centerCrop()
            .into(holder.productImage)
        holder.saleText.text= "${data[position].discountPercentage.toString()} %"
        holder.productBrand.text= data[position].brand
        var rand =
        Random.nextInt(1,6)
        if(rand==1){
            holder.star1.setImageResource(R.drawable.filledstar)
        }else if(rand==2){
            holder.star1.setImageResource(R.drawable.filledstar)
            holder.star2.setImageResource(R.drawable.filledstar)
        }
       else if( rand==3){
            holder.star1.setImageResource(R.drawable.filledstar)
            holder.star2.setImageResource(R.drawable.filledstar)
            holder.star3.setImageResource(R.drawable.filledstar)
        }
       else if(rand==4){
            holder.star1.setImageResource(R.drawable.filledstar)
            holder.star2.setImageResource(R.drawable.filledstar)
            holder.star3.setImageResource(R.drawable.filledstar)
            holder.star4.setImageResource(R.drawable.filledstar)
        }
       else if(rand==5){
            holder.star1.setImageResource(R.drawable.filledstar)
            holder.star2.setImageResource(R.drawable.filledstar)
            holder.star3.setImageResource(R.drawable.filledstar)
            holder.star4.setImageResource(R.drawable.filledstar)
            holder.star5.setImageResource(R.drawable.filledstar)
        }


    }

}