package com.example.forall.Database.localDataSource

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.forall.Database.Cart
import com.example.forall.Database.Converter
import com.example.forall.Database.Product
import com.example.forall.Database.User
import com.example.forall.Database.favourites
import com.example.forall.Database.productDao
import com.example.forall.Database.products

import com.example.forall.Database.userDao
import com.example.forall.Database.userWithCartDao
import com.example.forall.Database.userWithFavourites
import com.example.forall.Database.userWithFavouritesDao

@Database(entities = [User::class,Product::class,Cart::class,favourites::class] , version =3)
@TypeConverters(Converter::class)
    abstract class DataBase : RoomDatabase() {
        abstract fun productDao(): productDao
        abstract fun userWithCartDao(): userWithCartDao
        abstract fun userWithFavourites(): userWithFavouritesDao
        abstract fun userDao(): userDao

        companion object{
            @Volatile
            private var INSTANCE:DataBase?= null
            fun getInstance(context: Context):DataBase{
                return INSTANCE?: synchronized(this){
                    INSTANCE?: Room.databaseBuilder(
                        context.applicationContext,
                        DataBase::class.java,
                        "Userdata"
                    )   .fallbackToDestructiveMigration()
                        .build()
                        .also {
                            INSTANCE= it
                        }
                }
            }
        }
    }
