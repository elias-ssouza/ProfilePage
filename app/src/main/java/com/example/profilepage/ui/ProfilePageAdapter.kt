package com.example.profilepage.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.profilepage.data.ProfilePage
import com.example.profilepage.databinding.ProfileItemBinding

class ProfilePageAdapter :
        ListAdapter<ProfilePage, ProfilePageAdapter.ViewHolder>(DiffCallback()) {

        var listenerShare: (View) -> Unit = {}

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = ProfileItemBinding.inflate(inflater, parent, false)

            return ViewHolder(binding)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(getItem(position))
        }

        inner class ViewHolder(
            private val binding: ProfileItemBinding
        ) : RecyclerView.ViewHolder(binding.root) {

            fun bind(item: ProfilePage) {
                binding.tvTitle.text = item.title
                binding.tvSubtitle.text = item.subtitle
                binding.tvDescription.text = item.description
                binding.btComment.setOnClickListener {
                    listenerShare(it)
                }
            }
        }

    }

    class DiffCallback : DiffUtil.ItemCallback<ProfilePage>() {
        override fun areItemsTheSame(oldItem: ProfilePage, newItem: ProfilePage) = oldItem == newItem
        override fun areContentsTheSame(oldItem: ProfilePage, newItem: ProfilePage) =
            oldItem.id == newItem.id
    }