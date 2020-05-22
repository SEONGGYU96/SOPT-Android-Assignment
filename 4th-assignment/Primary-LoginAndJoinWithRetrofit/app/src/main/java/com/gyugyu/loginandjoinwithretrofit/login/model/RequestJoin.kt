package com.gyugyu.loginandjoinwithretrofit.login.model

data class RequestJoin(
    val id : String,
    val password : String,
    val name : String,
    val email : String,
    val phone : String
)