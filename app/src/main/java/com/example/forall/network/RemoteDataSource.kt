package com.example.forall.network

interface RemoteDataSource {
    suspend fun getProducts():products
}