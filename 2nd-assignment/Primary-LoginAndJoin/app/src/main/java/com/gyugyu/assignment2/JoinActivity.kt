package com.gyugyu.assignment2

import android.content.Intent
import android.os.Bundle
import com.gyugyu.assignment2.base.BaseActivity
import com.gyugyu.assignment2.databinding.ActivityJoinBinding
import kotlinx.android.synthetic.main.activity_join.*

class JoinActivity : BaseActivity<ActivityJoinBinding>(R.layout.activity_join) {
    private val JOIN_END = 20

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        button_join_join.setOnClickListener {
            var intent = Intent()
            intent.putExtra("email", edit_email_join.text.toString())
            intent.putExtra("password", edit_password_join.text.toString())
            setResult(JOIN_END, intent)
            finish()
        }
    }
}
