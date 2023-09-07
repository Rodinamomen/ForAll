package com.example.forall.network

import com.example.forall.Database.Product
import com.example.forall.Database.products
import retrofit2.http.GET

interface Service {
    @GET("products")
    suspend fun getproducts(): products
}