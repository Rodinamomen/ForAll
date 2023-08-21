package com.example.forall.Database

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

interface userWithFavouritesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addTofavourites(favourites: favourites)
    @Query("DELETE FROM favourites WHERE productId= :productId")
    suspend fun deleteFromFavouritesByProductID(productId: Int)
    @Query("SELECT * FROM Cart WHERE userId=:userId")
    suspend fun getAllProductsFromFavourites(userId:Int)
}