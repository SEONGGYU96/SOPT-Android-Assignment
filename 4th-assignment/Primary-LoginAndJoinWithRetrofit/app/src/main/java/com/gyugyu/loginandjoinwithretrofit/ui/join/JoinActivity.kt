package com.gyugyu.loginandjoinwithretrofit.ui.join

import android.os.Bundle
import android.widget.Toast
import com.gyugyu.loginandjoinwithretrofit.R
import com.gyugyu.loginandjoinwithretrofit.base.BaseActivity
import com.gyugyu.loginandjoinwithretrofit.databinding.ActivityJoinBinding
import com.gyugyu.loginandjoinwithretrofit.login.model.RequestJoin
import com.gyugyu.loginandjoinwithretrofit.login.model.ResponseJoin
import com.gyugyu.loginandjoinwithretrofit.login.network.RequestToServer
import kotlinx.android.synthetic.main.activity_join.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class JoinActivity : BaseActivity<ActivityJoinBinding>(R.layout.activity_join) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val requestToServer = RequestToServer

        button_join_join.setOnClickListener {
            requestToServer.service.requestJoin(
                RequestJoin(
                    id = edit_id_join.text.toString(),
                    password = edit_password_join.text.toString(),
                    name = edit_name_join.text.toString(),
                    email = edit_email_join.text.toString(),
                    phone = edit_number_join.text.toString()
                )
            ).enqueue(object : Callback<ResponseJoin> {
                override fun onResponse(call: Call<ResponseJoin>, response: Response<ResponseJoin>) {
                    if (response.isSuccessful) {

                        if (response.body()!!.success) {
                            Toast.makeText(applicationContext, getString(R.string.success_to_join), Toast.LENGTH_SHORT).show()
                            finish()
                        }
                    } else {

                        Toast.makeText(applicationContext, getString(R.string.fail_to_join), Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<ResponseJoin>, t: Throwable) {
                    Toast.makeText(applicationContext, getString(R.string.fail_to_join), Toast.LENGTH_SHORT).show()
                }
            })
        }
    }
}
