package com.example.library.libone.ui.ui.users

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.library.databinding.ItemUserBinding
import com.example.library.libone.ui.ui.imageloading.ImageLoader
import com.example.library.libone.model.GithubUserModel

class UsersAdapter(
    private val itemClickListener: (GithubUserModel) -> Unit,
    private val imageLoader: ImageLoader<ImageView>
) : ListAdapter<GithubUserModel, UsersAdapter.UserViewHolder>(GithubUserItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.showUser(currentList[position])
    }

    inner class UserViewHolder(private val vb: ItemUserBinding) : RecyclerView.ViewHolder(vb.root) {

        fun showUser(user: GithubUserModel) {
            vb.root.setOnClickListener { itemClickListener(user) }
            vb.tvLogin.text = user.login
            imageLoader.loadInto(user.avatarUrl, vb.userImage)
        }
    }
}

object GithubUserItemCallback : DiffUtil.ItemCallback<GithubUserModel>() {

    override fun areItemsTheSame(oldItem: GithubUserModel, newItem: GithubUserModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: GithubUserModel, newItem: GithubUserModel): Boolean {
        return oldItem == newItem
    }
}