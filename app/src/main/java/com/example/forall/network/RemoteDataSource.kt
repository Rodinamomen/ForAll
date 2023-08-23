package com.example.forall.network

import com.example.forall.Database.products

interface RemoteDataSource {
    suspend fun getProducts(): products
}