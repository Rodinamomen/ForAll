package com.example.forall.Authentication.Login.Repo

import com.example.forall.Database.localDataSource.localDatabaseImp

class loginRepoImp(val localDatabaseImp: localDatabaseImp): loginRepo {
    override suspend fun ifUserWithEmailExists(email: String): Boolean {
       return localDatabaseImp.ifUserWithEmailExists(email)
    }
    override suspend fun ifEmailMatchesPassword(email: String, password: String): Boolean {
        return localDatabaseImp.ifEmailMatchesPassword(email, password)
    }
}