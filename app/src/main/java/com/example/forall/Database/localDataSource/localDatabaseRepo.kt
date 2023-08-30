package com.example.forall.Database.localDataSource

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.forall.Database.Product
import com.example.forall.Database.User

interface localDatabaseRepo {

    suspend fun addUser(user: User)
    suspend fun deleteUser(user: User)
    suspend fun getUserById(userId:Int):User
    suspend fun ifUserWithEmailExists(email:String):Boolean
    suspend fun ifEmailMatchesPassword(email: String , password :String):Boolean
    suspend fun getproductslist(): List<Product>

}