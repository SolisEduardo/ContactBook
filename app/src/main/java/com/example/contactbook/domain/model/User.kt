package com.example.contactbook.domain.model

import androidx.room.ColumnInfo
import com.example.contactbook.data.database.entities.UserEntity
import com.example.contactbook.data.model.UserModel
import com.example.contactbook.data.model.UserModelItem

data class User(
    val lastName: String,

    val avatar: String,

    val firstName: String,

    val email: String,
)

fun UserModelItem.toDomain() = User(lastName!!, avatar!!,firstName!!,email!!)

fun UserEntity.toDomain() = User(lastName!!, avatar!!,firstName!!,email!!)
