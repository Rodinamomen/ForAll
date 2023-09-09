package com.example.forall.Database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface productDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addProduct(product: Product)
    @Delete
    suspend fun deleteProduct(product: Product)
    @Query("SELECT * FROM product WHERE productId = :productId")
    suspend fun getProductById(productId:Int): Product

}