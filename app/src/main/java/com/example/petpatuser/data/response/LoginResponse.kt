package com.example.petpatuser.data.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class LoginResponse(
    val `data`: Data,
    val message: String,
    val success: Boolean
) : Parcelable {
    @Parcelize
    data class Data(
        val access_token: String,
        val phone: String,
        val refresh_token: String,
        val service_provider_id: Int,
        val user_id: Int,
        val user_profile_id: Int
    ) : Parcelable
}