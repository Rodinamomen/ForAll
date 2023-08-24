package com.example.forall.Authentication.Signup.Repo

import com.example.forall.Database.User

interface signupRepo {
    suspend fun addUser(user: User)
    suspend fun deleteUser(user: User)
    suspend fun getUserById(userId:Int):User
    suspend fun ifUserWithEmailExists(email:String):Boolean
}