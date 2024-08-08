package com.sierratechnologies.Discreet

//import com.sierratechnologies.Discreet.databinding.ActivitySplashBinding
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.sierratechnologies.Discreet.databinding.ActivitySplashBinding


class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        enableEdgeToEdge()


        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)


        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        val fadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out)

        binding.textView.startAnimation(fadeIn)
        binding.textView.postDelayed({
            binding.textView.startAnimation(fadeOut)
        }, 2000)

        // Delay for 3 seconds and then start MockLogin activity
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, MockLogin::class.java))
            finish()
        }, 3000)
    }
}
