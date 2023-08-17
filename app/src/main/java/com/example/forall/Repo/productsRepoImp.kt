package com.example.forall.Repo

import com.example.forall.network.RemoteDataSource
import com.example.forall.network.products

class productRepoImp(val remoteDataSource: RemoteDataSource) :productsRepo{
    override suspend fun getProductsFromApi(): products {
        return remoteDataSource.getProducts()
    }
}