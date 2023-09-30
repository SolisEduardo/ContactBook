package com.example.contactbook.ui.view

import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelStore
import com.bumptech.glide.Glide
import com.example.contactbook.databinding.ActivityMainBinding
import com.example.contactbook.ui.viewmodel.GetUserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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
            for (i in users!!.iterator()){
               // Glide.with(this).load(i.avatar).into(binding.imageView)
                binding.textView.text = i.firstName.toString()
                binding.textView2.text = i.lastName.toString()
                binding.textView3.text = i.email.toString()
                binding.textView4.text = i.password.toString()
                binding.textView5.text = i.creditCard!!.ccNumber.toString()
                Log.i(TAG,"UserName: ${i.username} \t Name: ${i.firstName} \t lastName: ${i.lastName} \t Email: ${i.email} \t Password: ${i.password} \t Credit: ${i.creditCard!!.ccNumber}")


            }
        })
        getUserViewModel.isLoading.observe(this, Observer {
            binding.progressDialog.isVisible = it
        })
        getUserViewModel.errorMessage.observe(this, Observer {
            Log.e(TAG,it.toString())
        })
    }
}