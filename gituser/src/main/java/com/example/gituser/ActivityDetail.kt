package com.example.gituser

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.gituser.databinding.ActivityDetailBinding

class ActivityDetail : AppCompatActivity() {
    companion object {
        const val USER_EXTRA = "extra_user"
    }
    private lateinit var detailBinding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(detailBinding.root)

        val githubUser =
            intent.getParcelableExtra<UserModel>(USER_EXTRA) as UserModel

        detailBinding.tvUsername.text = getString(R.string.get_username, githubUser.username)
        detailBinding.tvName.text = githubUser.name
        detailBinding.imgPhoto.setImageResource(githubUser.photoProfile)
    }
}