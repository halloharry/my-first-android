package com.example.usergithub

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Users(
    val items: List<User>
): Parcelable

@Parcelize
data class User(
    val id: String,
    val name: String,
    @SerializedName("avatar_url")
    val photoProfile: String,
    @SerializedName("login")
    val username: String,
    @SerializedName("type")
    val userType: String
): Parcelable