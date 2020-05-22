package com.gyugyu.loginandjoinwithretrofit.login.model

data class ResponseLogin (
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: SomeData?
)

data class SomeData (
    val jwt: String
)