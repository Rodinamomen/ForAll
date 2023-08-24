package com.example.forall.Database.localDataSource

import android.content.Context
import com.example.forall.Database.User
import com.example.forall.Database.productDao
import com.example.forall.Database.userDao
import com.example.forall.Database.userWithCartDao
import com.example.forall.Database.userWithFavourites
import com.example.forall.Database.userWithFavouritesDao

class localDatabaseImp(context: Context):localDatabaseRepo {
    private lateinit var userDao: userDao
    private lateinit var productDao: productDao
    private lateinit var cartDao: userWithCartDao
    private lateinit var favouritesDao: userWithFavouritesDao
    init {
        val db =DataBase.getInstance(context)
         userDao = db.userDao()
        productDao=db.productDao()
        cartDao=db.userWithCartDao()
        favouritesDao= db.userWithFavourites()
    }
    override suspend fun addUser(user: User) {
        userDao.addUser(user)
    }

    override suspend fun deleteUser(user: User) {
        userDao.deleteUser(user)
    }

    override suspend fun getUserById(userId: Int) :User{
        return userDao.getUserById(userId)
    }

    override suspend fun ifUserWithEmailExists(email: String): Boolean {
        return userDao.ifUserWithEmailExists(email)
    }
    override suspend fun ifEmailMatchesPassword(email: String, password: String): Boolean {
        return userDao.ifEmailMatchesPassword(email, password)
    }
}