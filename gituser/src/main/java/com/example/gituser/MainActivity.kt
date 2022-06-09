package com.example.gituser

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gituser.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    private val listUserModel = ArrayList<UserModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        mainBinding.user.setHasFixedSize(true)
        listUserModel.addAll(users)
        showRecyclerList()
    }

    private val users: ArrayList<UserModel>
        get() {
            val dataUsername = resources.getStringArray(R.array.username)
            val dataName = resources.getStringArray(R.array.name)
            val dataLocation = resources.getStringArray(R.array.name)
            val dataCompany = resources.getStringArray(R.array.company)
            val dataPhoto = resources.obtainTypedArray(R.array.photo)
            val listUser = ArrayList<UserModel>()
            for (i in dataUsername.indices) {
                val githubUser = UserModel(
                    dataUsername[i],
                    dataName[i],
                    dataPhoto.getResourceId(i, -1),
                    dataCompany[i],
                    dataLocation[i],
                )
                listUser.add(githubUser)
            }
            dataPhoto.recycle()
            return listUser
        }

    private fun showRecyclerList() {
        mainBinding.user.layoutManager = LinearLayoutManager(this)
        val listGithubUserAdapter = UserAdapter(listUserModel)
        mainBinding.user.adapter = listGithubUserAdapter
    }
}


