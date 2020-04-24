package com.gyugyu.assignment2

import android.content.Intent
import android.os.Bundle
import com.gyugyu.assignment2.base.BaseActivity
import com.gyugyu.assignment2.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    private val REQUEST_JOIN = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        text_join_main.setOnClickListener {
            intent = Intent(this, JoinActivity::class.java)
            startActivityForResult(intent, REQUEST_JOIN)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_JOIN) {
            edit_email_main.setText(data!!.getStringExtra("email"))
            edit_password_main.setText(data.getStringExtra("password"))
        }
    }
}
