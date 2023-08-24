package com.example.forall.Database

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class userWithFavourites(
    @Embedded
    val user: User,
    @Relation(
        parentColumn = "userId",
        entityColumn = "productId",
        associateBy = Junction(favourites::class)
    )
    val product: List<Product>
)