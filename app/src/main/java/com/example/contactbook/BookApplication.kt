package com.example.contactbook

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate

class BookApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }
}