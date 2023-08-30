package com.example.forall.Home.repo

import com.example.forall.Database.Product
import com.example.forall.Database.localDataSource.localDatabaseImp
import com.example.forall.network.RemoteDataSource

class homeRepoImp( val remoteDataSource: RemoteDataSource) : homeRepo{
    override suspend fun getproductslist(): List<Product> {
        return remoteDataSource.getProducts().products
    }
}