package com.example.forall.Database

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class userWithCart (
    @Embedded
    val user: User,
    @Relation(
        parentColumn = "userId",
        entityColumn = "productId",
        associateBy = Junction(Cart::class)
    )
    val product: List<Product>
        )