package com.example.forall.Database

import androidx.room.Entity

import com.example.forall.Database.Product
data class products(

    val limit: Int,
    val products: ArrayList<Product>,
    val skip: Int,
    val total: Int
)