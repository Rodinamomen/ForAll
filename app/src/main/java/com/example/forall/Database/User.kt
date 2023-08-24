package com.example.forall.Database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("user")
data class User(
    @PrimaryKey(autoGenerate = true) val userId : Int =0,
    val userName :String,
    val email :String,
    val password :String
)