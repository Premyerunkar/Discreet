package com.sierratechnologies.Discreet

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class IntroActivity : AppCompatActivity() {
    lateinit var next_btn:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        // Get references to the views
        val txt = findViewById<View>(R.id.txt)
        val txt1 = findViewById<View>(R.id.txt1)
        val txt2 = findViewById<View>(R.id.txt2)
        val c0 = findViewById<View>(R.id.c0)
        val c1 = findViewById<View>(R.id.c1)
        val c2 = findViewById<View>(R.id.c2)
        next_btn=findViewById(R.id.next_button)

        next_btn.setOnClickListener{
            val intent= Intent(this@IntroActivity,IntroActivity2::class.java)
            startActivity(intent)
            finish()
        }




    }
}
