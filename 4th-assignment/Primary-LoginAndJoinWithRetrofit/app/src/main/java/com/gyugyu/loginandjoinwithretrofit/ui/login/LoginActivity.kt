package com.gyugyu.loginandjoinwithretrofit.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.gyugyu.loginandjoinwithretrofit.R
import com.gyugyu.loginandjoinwithretrofit.base.BaseActivity
import com.gyugyu.loginandjoinwithretrofit.databinding.ActivityLoginBinding
import com.gyugyu.loginandjoinwithretrofit.login.model.RequestLogin
import com.gyugyu.loginandjoinwithretrofit.login.model.ResponseLogin
import com.gyugyu.loginandjoinwithretrofit.login.network.RequestToServer
import com.gyugyu.loginandjoinwithretrofit.ui.join.JoinActivity
import com.gyugyu.loginandjoinwithretrofit.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : BaseActivity<ActivityLoginBinding>(R.layout.activity_login) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var requestToServer = RequestToServer

        button_login_main.setOnClickListener {
            if (edit_id_main.text.isNullOrBlank() || edit_password_main.text.isNullOrBlank()) {
                Toast.makeText(applicationContext, getString(R.string.please_check_id_and_password), Toast.LENGTH_SHORT).show()

            } else {
                requestToServer.service.requestLogin(
                    RequestLogin(
                        id = edit_id_main.text.toString(),
                        password = edit_password_main.text.toString()
                    )
                ).enqueue(object : Callback<ResponseLogin> {
                    override fun onResponse(call: Call<ResponseLogin>, response: Response<ResponseLogin>) {
                        if (response.isSuccessful) {

                            if (response.body()!!.success) {
                                Toast.makeText(applicationContext, getString(R.string.success_to_login), Toast.LENGTH_SHORT).show()
                                startActivity(Intent(baseContext, MainActivity::class.java))
                                finish()
                            } else {

                                Toast.makeText(applicationContext, getString(R.string.please_check_id_and_password), Toast.LENGTH_SHORT).show()
                            }
                        }
                    }

                    override fun onFailure(call: Call<ResponseLogin>, t: Throwable) {
                        Toast.makeText(applicationContext, getString(R.string.fail_to_response), Toast.LENGTH_SHORT).show()
                    }
                })
            }
        }

        text_join_main.setOnClickListener {
            startActivity(Intent(this, JoinActivity::class.java))
        }
    }
}
