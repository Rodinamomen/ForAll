package com.example.forall.Database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
@Dao
interface userWithFavouritesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addTofavourites(favourites: favourites)
    @Query("DELETE FROM favourites WHERE productId= :productId")
    suspend fun deleteFromFavouritesByProductID(productId: Int)
    @Query("SELECT * FROM favourites WHERE userId=:userId")
    suspend fun getAllProductsFromFavourites(userId:Int) : List<favourites>
}