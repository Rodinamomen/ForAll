package com.example.forall.Database

import com.example.forall.Database.Product

data class products(
    val limit: Int,
    val products: List<Product>,
    val skip: Int,
    val total: Int
)