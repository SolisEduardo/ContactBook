package com.example.contactbook.ui.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.contactbook.R
import com.example.contactbook.databinding.ActivitySplashScreenBinding


class SplashScreen : AppCompatActivity() {
    private lateinit var binding: ActivitySplashScreenBinding
    private lateinit var topAnim: Animation
    private lateinit var bottomAnim: Animation
    private var handler = Handler()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(binding.root)
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation)
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.botton_animation)

        binding.imgLogo.animation = topAnim
        binding.txtName.animation = bottomAnim
        binding.txtVersion.animation = bottomAnim

        handler.postDelayed({
            startActivity(Intent(this@SplashScreen,MainActivity::class.java))
            finish()
        }, SPLASH_SCREEN)


    }

    companion object {
        private const val SPLASH_SCREEN: Long = 3000
    }

}



