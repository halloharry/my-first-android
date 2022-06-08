package com.example.usergithub

import android.content.Context
import com.google.gson.Gson
import java.io.IOException
import java.io.InputStream
import java.nio.charset.Charset

object UserData {
    fun getUsers(userContext: Context): Users {
        val strJson = loadJsonFile(userContext)
        strJson?.let {
            return Gson().fromJson(it, Users::class.java)
        }
        return Users(listOf())
    }

    private fun loadJsonFile(jsonContext: Context): String? {
        return try {
            val `is`: InputStream = jsonContext.assets.open("ListUser.json")
            val size: Int = `is`.available()
            val buffer = ByteArray(size)
            `is`.read(buffer)
            `is`.close()
            String(buffer, Charset.forName("UTF-8"))
        } catch (ex: IOException) {
            ex.message
        }
    }
}