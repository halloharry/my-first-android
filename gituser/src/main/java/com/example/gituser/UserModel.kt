package com.example.gituser

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserModel(
    val username: String,
    val name: String,
    val photoProfile: Int,
    val company: String,
    val location: String,
) : Parcelable