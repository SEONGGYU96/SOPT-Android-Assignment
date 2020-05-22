package com.gyugyu.loginandjoinwithretrofit.login.network

import com.gyugyu.loginandjoinwithretrofit.login.model.RequestJoin
import com.gyugyu.loginandjoinwithretrofit.login.model.RequestLogin
import com.gyugyu.loginandjoinwithretrofit.login.model.ResponseJoin
import com.gyugyu.loginandjoinwithretrofit.login.model.ResponseLogin
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RequestInterface {
    @POST("/user/signin")
    fun requestLogin(@Body body: RequestLogin) : Call<ResponseLogin>

    @POST("/user/signup")
    fun requestJoin(@Body body: RequestJoin) : Call<ResponseJoin>
}