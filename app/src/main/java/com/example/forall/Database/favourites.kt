package com.example.forall.Database

import androidx.room.Entity

@Entity(primaryKeys = ["userId","productId"])
data class favourites (
    val userId :String ,
    val productId : String
    )