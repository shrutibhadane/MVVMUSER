package com.example.enfecdemo.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.enfecdemo.R
import com.example.enfecdemo.database.model.Users

class UsersListAdapter(private val onClickListener: (Users) -> Unit) :
    ListAdapter<Users, UserViewHolder>(UserDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_users, parent, false)
        return UserViewHolder(view, onClickListener)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.item = getItem(position)
    }

}

class UserViewHolder(private val view: View, private val onClickListener: (Users) -> Unit) :
    RecyclerView.ViewHolder(view) {

    var item: Users? = null
        set(value) {
            value?.let { newValue ->
                field = newValue
                view.setOnClickListener { onClickListener(newValue) }
                view.findViewById<TextView>(R.id.textViewName).text = newValue.username
                view.findViewById<TextView>(R.id.textViewId).text = "${newValue.id}"
            }
        }
}

class UserDiffCallback : DiffUtil.ItemCallback<Users>() {

    override fun areItemsTheSame(oldItem: Users, newItem: Users): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Users, newItem: Users): Boolean {
        return oldItem == newItem
    }
}