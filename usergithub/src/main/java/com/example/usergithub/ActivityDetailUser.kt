package com.example.usergithub

import android.R
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.usergithub.databinding.ActivityDetailUserBinding

class ActivityDetailUser : AppCompatActivity() {
    private lateinit var detailBinding: ActivityDetailUserBinding
    private var user: User? = null

    companion object {
        const val USER_PROFILE = "USER_PROFILE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding = ActivityDetailUserBinding.inflate(layoutInflater)
        setContentView(detailBinding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val color = ContextCompat.getColor(this, R.color.white);
        detailBinding.toolbar.navigationIcon?.setTint(color)

        user = intent.getParcelableExtra(USER_PROFILE)
        setView()
    }

    private fun setView() {
        detailBinding.apply {
            tvName.text = user?.name ?: "unidentified"
            tvUsername.text = "@${user?.username}" ?: "-"

            Glide.with(root.context)
                .load(user?.photoProfile)
                .into(imgProfile)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}