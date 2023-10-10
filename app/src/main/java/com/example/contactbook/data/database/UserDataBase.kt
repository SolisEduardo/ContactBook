package com.example.contactbook.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.contactbook.data.database.dao.UserDao
import com.example.contactbook.data.database.entities.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class UserDataBase : RoomDatabase() {
    abstract fun getUserDao(): UserDao
}