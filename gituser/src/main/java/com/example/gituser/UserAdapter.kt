package com.example.gituser

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gituser.databinding.ActivityListUserBinding

class UserAdapter(private val listUser: ArrayList<UserModel>) :
    RecyclerView.Adapter<UserAdapter.ListViewHolder>() {

    class ListViewHolder(var userBinding: ActivityListUserBinding) : RecyclerView.ViewHolder(userBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val listUserBinding =
            ActivityListUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(listUserBinding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (username, name, avatar, company, location) = listUser[position]
        holder.userBinding.imgAvatar.setImageResource(avatar)
        holder.userBinding.tvName.text = name
        holder.userBinding.tvCompany.text = company
        holder.userBinding.tvLocation.text = location

        holder.itemView.setOnClickListener {
            val githubUser = UserModel(
                username,
                name,
                avatar,
                company,
                location
            )
            val objectIntent =
                Intent(holder.itemView.context, ActivityDetail::class.java)
            objectIntent.putExtra(ActivityDetail.USER_EXTRA, githubUser)
            holder.itemView.context.startActivity(objectIntent)
        }
    }

    override fun getItemCount(): Int = listUser.size
}