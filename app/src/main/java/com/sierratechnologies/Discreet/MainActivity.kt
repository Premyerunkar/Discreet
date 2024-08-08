package com.sierratechnologies.Discreet

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener
import com.zegocloud.uikit.prebuilt.call.invite.widget.ZegoSendCallInvitationButton
import com.zegocloud.uikit.service.defines.ZegoUIKitUser
import java.util.Collections

class MainActivity : AppCompatActivity() {
    lateinit var currentUsernameTextView: TextView
    lateinit var targetUsernameInput: EditText
    lateinit var voiceCallBtn: ZegoSendCallInvitationButton
    lateinit var videoCallBtn: ZegoSendCallInvitationButton
    lateinit var backButton:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        window.statusBarColor = android.graphics.Color.TRANSPARENT
        window.decorView.systemUiVisibility = android.view.View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                android.view.View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Back
        var backButton=findViewById<Button>(R.id.back)

        backButton.setOnClickListener{
            val intent=Intent(this@MainActivity,MockLogin::class.java)
            startActivity(intent)
        }

        currentUsernameTextView = findViewById(R.id.curent_username_textview)
        targetUsernameInput = findViewById(R.id.target_username_input)
        voiceCallBtn = findViewById(R.id.voice_call_btn)
        videoCallBtn = findViewById(R.id.video_call_btn)

        currentUsernameTextView.text = "Hello"
        currentUsernameTextView.text = intent.getStringExtra("username")

        targetUsernameInput.addTextChangedListener {
            val targetUsername = targetUsernameInput.text.toString()
            setupVoiceCall(targetUsername)
            setupVideoCall(targetUsername)
        }
    }




    private fun setupVoiceCall(username: String) {
        Log.d("MainActivity", "Setting up voice call for user: $username")
        voiceCallBtn.setIsVideoCall(false)
        voiceCallBtn.resourceID = "zego_uikit_call"
        voiceCallBtn.setInvitees(Collections.singletonList(ZegoUIKitUser(username, username)))
    }

    private fun setupVideoCall(username: String) {
        Log.d("MainActivity", "Setting up video call for user: $username")
        videoCallBtn.setIsVideoCall(true)
        videoCallBtn.resourceID = "zego_uikit_call"
        videoCallBtn.setInvitees(Collections.singletonList(ZegoUIKitUser(username, username)))
    }
}
