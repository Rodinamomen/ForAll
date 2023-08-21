package com.example.forall.Database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("product")
data class Product(
   @PrimaryKey(autoGenerate = true) val productId :Int=0 ,
    val brand: String,
    val category: String,
    val description: String,
    val discountPercentage: Double,
    val id: Int,
    val images: List<String>,
    val price: Int,
    val rating: Double,
    val stock: Int,
    val thumbnail: String,
    val title: String
)