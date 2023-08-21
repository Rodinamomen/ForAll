package com.example.forall.Database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface userDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addUser(user: User)
    @Delete
    suspend fun deleteUser(user: User)
    @Query("SELECT * FROM user WHERE userId=:userId")
    suspend fun getUserById(userId:Int)

}