package com.example.petpatuser.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.petpatuser.data.request.LoginRequest
import com.example.petpatuser.data.response.LoginResponse
import com.example.petpatuser.repository.LoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val repository: LoginRepository) :
    ViewModel() {
    private val loginResponse = MutableLiveData<LoginResponse>()
  //  val loginResponse_: LiveData<LoginResponse> get() = loginResponse

    fun login(phoneNumber: String, password: String) {
        viewModelScope.launch {
            try {
                val loginRequest = LoginRequest(phoneNumber, password)
                val response = repository.login(loginRequest)
                if (response.isSuccessful) {
                    // Handle successful login
                    //loginResponse_.value = LoginResponse.Success(response.body())
                    loginResponse.postValue(response.body())
                } else {
                    // Handle login failure
                    //  _loginResult.value = LoginResult.Error("Login failed")
                }
            } catch (e: Exception) {
                // Handle network errors
                //_loginResult.value = LoginResult.Error("Network error")
            }
        }
    }
}
