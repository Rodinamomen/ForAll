package com.example.forall.network

object Client:RemoteDataSource {
    override suspend fun getProducts(): products {
        return Helper.retrofit.create(Service::class.java).getproducts()
    }
}