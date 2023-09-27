package com.example.win43.retrofit

import com.example.win43.model.BodyModel
import com.example.win43.model.SplashModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("splash.php")
    suspend fun postQuery(@Body bodyModel: BodyModel): Response<SplashModel>
}