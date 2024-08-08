package com.sierratechnologies.Discreet

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.zegocloud.uikit.prebuilt.call.ZegoUIKitPrebuiltCallService
import com.zegocloud.uikit.prebuilt.call.invite.ZegoUIKitPrebuiltCallInvitationConfig

class MockLogin : AppCompatActivity() {
    lateinit var usernameInput:EditText
    lateinit var loginBtn:Button
    lateinit var call:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_mock_login)

        usernameInput=findViewById(R.id.username_input)
        loginBtn=findViewById(R.id.login_btn)
        call=findViewById(R.id.login_btn2)


        window.statusBarColor = android.graphics.Color.TRANSPARENT
        window.decorView.systemUiVisibility = android.view.View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                android.view.View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN

        //Recieve
        loginBtn.setOnClickListener{
            val username=usernameInput.text.toString()
            val config=ZegoUIKitPrebuiltCallInvitationConfig()
            ZegoUIKitPrebuiltCallService.init(application,AppConstants.appId,AppConstants.appSign,username,username,config)
            val intent=Intent(this@MockLogin,MainActivity::class.java)
            intent.putExtra("username",username)
            startActivity(intent)
            finish()
        }

        //Call
        call.setOnClickListener{
            val username=usernameInput.text.toString()
            val config=ZegoUIKitPrebuiltCallInvitationConfig()
            ZegoUIKitPrebuiltCallService.init(application,AppConstants.appId,AppConstants.appSign,username,username,config)
            val intent=Intent(this@MockLogin,MainActivity::class.java)
            intent.putExtra("username",username)
            startActivity(intent)
            finish()
        }
    }
}