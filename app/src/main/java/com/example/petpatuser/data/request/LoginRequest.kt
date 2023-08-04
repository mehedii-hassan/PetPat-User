package com.example.petpatuser.data.request

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class LoginRequest(
    val phone: String,
    val password: String
) : Parcelable