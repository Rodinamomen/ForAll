package com.example.forall.Database

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

interface userWithCartDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addToCart(cart: Cart)
    @Query("DELETE FROM Cart WHERE productId= :productId")
    suspend fun deleteFromCartByProductID(productId: Int)
    @Query("SELECT * FROM Cart WHERE userId=:userId")
    suspend fun getAllProductsFromCart(userId:Int)

}