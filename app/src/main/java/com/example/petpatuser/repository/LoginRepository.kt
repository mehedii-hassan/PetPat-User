package com.example.petpatuser.repository

import com.example.petpatuser.data.request.LoginRequest
import com.example.petpatuser.data.response.LoginResponse
import com.example.petpatuser.network.ApiService
import retrofit2.Response
import javax.inject.Inject

class LoginRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun login(loginRequest: LoginRequest): Response<LoginResponse> {
        return apiService.userLogin(loginRequest)
    }
}
