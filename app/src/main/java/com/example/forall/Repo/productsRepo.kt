package com.example.forall.Repo

import com.example.forall.Database.products

interface productsRepo {
    suspend fun getProductsFromApi(): products
}