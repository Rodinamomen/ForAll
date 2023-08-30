package com.example.forall.Home.repo

import com.example.forall.Database.Product

interface homeRepo {
    suspend fun getproductslist(): List<Product>
}