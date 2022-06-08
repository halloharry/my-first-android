package com.example.usergithub

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.usergithub.databinding.ContainerListUserBinding


class UserListAdapter(
    private val listUser: List<User>
) : RecyclerView.Adapter<UserListAdapter.UserViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: MainActivity) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(user: User)
    }

    inner class UserViewHolder(private val userBinding: ContainerListUserBinding) :
        RecyclerView.ViewHolder(userBinding.root) {
        fun bindUser(user: User) {
            userBinding.apply {
                tvName.text = user.name
                tvUserType.text = user.userType

                Glide.with(root.context)
                    .load(user.photoProfile)
                    .transform(RoundedCorners(20))
                    .into(imgProfile)

                root.setOnClickListener {
                    onItemClickCallback.onItemClicked(user)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val containerListUserBinding =
            ContainerListUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(containerListUserBinding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = listUser[position]
        holder.bindUser(user)
    }

    override fun getItemCount(): Int = listUser.size
}