package com.example.forall.network

import retrofit2.http.GET

interface Service {
    @GET("products")
    suspend fun getproducts():products
}