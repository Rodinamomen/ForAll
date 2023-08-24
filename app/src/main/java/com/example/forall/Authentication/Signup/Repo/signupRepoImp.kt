package com.example.forall.Authentication.Signup.Repo

import com.example.forall.Database.User
import com.example.forall.Database.localDataSource.localDatabaseImp

class signupRepoImp(val localDatabaseImp: localDatabaseImp):signupRepo {
    override suspend fun addUser(user: User) {
        localDatabaseImp.addUser(user)
    }

    override suspend fun deleteUser(user: User) {
        localDatabaseImp.deleteUser(user)
    }

    override suspend fun getUserById(userId: Int): User {
        return localDatabaseImp.getUserById(userId)
    }

    override suspend fun ifUserWithEmailExists(email: String): Boolean {
        return localDatabaseImp.ifUserWithEmailExists(email)
    }
}