package com.example.contactbook.ui.view

import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelStore
import com.example.contactbook.databinding.ActivityMainBinding
import com.example.contactbook.ui.viewmodel.GetUserViewModel

class MainActivity : AppCompatActivity() {
    private val getUserViewModel : GetUserViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private val TAG : String =MainActivity::class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getUserViewModel.getAllUser()
        getUserViewModel.getUser.observe(this, Observer {users ->
            for (i in users!!.iterator())
            Log.i(TAG,"UserName: ${i.username} \t Name: ${i.firstName} \t lastName: ${i.lastName} \t Email: ${i.email} \t Password: ${i.password} \t Credit: ${i.creditCard!!.ccNumber}")

        })
    }
}