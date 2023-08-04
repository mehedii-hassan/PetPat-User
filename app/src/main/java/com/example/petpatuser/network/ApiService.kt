package com.example.petpatuser.network

import com.example.petpatuser.data.request.LoginRequest
import com.example.petpatuser.data.response.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("login")
    suspend fun userLogin(@Body loginRequest: LoginRequest): Response<LoginResponse>


}