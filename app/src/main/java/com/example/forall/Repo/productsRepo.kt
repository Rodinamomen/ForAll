package com.example.forall.Repo

import com.example.forall.network.products

interface productsRepo {
    suspend fun getProductsFromApi():products
}