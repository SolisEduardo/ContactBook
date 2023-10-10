package com.example.contactbook.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.contactbook.data.model.Address
import com.example.contactbook.data.model.CreditCard
import com.example.contactbook.data.model.Employment
import com.example.contactbook.data.model.Subscription
import com.example.contactbook.domain.model.User
import com.google.gson.annotations.SerializedName

@Entity(tableName = "user_table")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id") val id: Int = 0,

    @ColumnInfo("last_name") val lastName: String? = null,

    @ColumnInfo("avatar") val avatar: String? = null,

    @ColumnInfo("first_name") val firstName: String? = null,

    @ColumnInfo("email") val email: String? = null,
)

fun User.toDataBase() =
    UserEntity(lastName = lastName, avatar = avatar, firstName = firstName, email = email)
