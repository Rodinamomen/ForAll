package com.example.forall.network

import com.example.forall.Database.products

object Client:RemoteDataSource {
    override suspend fun getProducts(): products {
        return Helper.retrofit.create(Service::class.java).getproducts()
    }
}