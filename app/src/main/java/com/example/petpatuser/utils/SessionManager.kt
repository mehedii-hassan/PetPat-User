package com.example.petpatuser.utils

import android.content.Context
import android.content.SharedPreferences

object SessionManager {
    private const val SHARED_PREF_NAME = "PetPat"
    private const val KEY_ACCESS_TOKEN = "access_token"

    //Initialize SharedPreferences-----------------------
    private fun getSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
    }

    //Save the access_token to SharedPreferences------------------------------
    fun saveAccessToken(context: Context, accessToken: String) {
        saveAccessTokenToSharedPreferences(context, accessToken)

    }

    private fun saveAccessTokenToSharedPreferences(context: Context, accessToken: String) {
        val editor = getSharedPreferences(context).edit()
        editor.putString(KEY_ACCESS_TOKEN, accessToken)
        editor.apply()
    }

    // Get the access token from SharedPreferences
    fun getAccessToken(context: Context): String? {
        return getSharedPreferences(context).getString(KEY_ACCESS_TOKEN, null)
    }

    // Clear the access token from SharedPreferences
    fun clearAccessToken(context: Context) {
        val editor = getSharedPreferences(context).edit()
        editor.remove(KEY_ACCESS_TOKEN)
        editor.apply()
    }

    // Check if the user is logged in based on the presence of the access token
    fun isLoggedIn(context: Context): Boolean {
        return getAccessToken(context) != null
    }


}