package com.example.usergithub

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.usergithub.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), UserListAdapter.OnItemClickCallback {
    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        getUserJson()
    }

    private fun getUserJson() {
        val users = UserData.getUsers(this)
        setRecyclerView(users.items)
    }

    private fun setRecyclerView(listUser: List<User>) {
        val userListAdapter = UserListAdapter(listUser)
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        userListAdapter.setOnItemClickCallback(this)
        activityMainBinding.rvUsers.adapter = userListAdapter
        activityMainBinding.rvUsers.layoutManager = linearLayoutManager
    }

    override fun onItemClicked(user: User) {
        val intent = Intent(this@MainActivity, ActivityDetailUser::class.java)
        intent.putExtra(ActivityDetailUser.USER_PROFILE, user)
        startActivity(intent)
    }
}