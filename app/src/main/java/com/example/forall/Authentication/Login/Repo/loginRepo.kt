package com.example.forall.Authentication.Login.Repo

interface loginRepo {
    suspend fun ifUserWithEmailExists(email:String):Boolean
    suspend fun ifEmailMatchesPassword(email: String , password :String):Boolean
}