package com.example.forall.network

data class products(
    val limit: Int,
    val products: List<Product>,
    val skip: Int,
    val total: Int
)