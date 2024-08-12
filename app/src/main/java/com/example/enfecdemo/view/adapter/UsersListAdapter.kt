package com.example.enfecdemo.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.enfecdemo.R
import com.example.enfecdemo.model.database.model.Users

/**
 * Adapter for the Users RecyclerView.
 * @param onClickListener a lambda function to handle item clicks.
 */
class UsersListAdapter(private val onClickListener: (Users) -> Unit) :
    ListAdapter<Users, UserViewHolder>(UserDiffCallback()) {

    /**
     * Creates a new UserViewHolder instance.
     * @param parent the parent view group.
     * @param viewType the type of the view.
     * @return a new UserViewHolder instance.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_users, parent, false)
        return UserViewHolder(view, onClickListener)
    }

    /**
     * Binds data to the UserViewHolder.
     * @param holder the UserViewHolder to bind data to.
     * @param position the position of the item in the list.
     */
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.item = getItem(position)
    }

}

/**
 * ViewHolder for a single User item.
 * @param view the view for the User item.
 * @param onClickListener a lambda function to handle item clicks.
 */
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

/**
 * DiffUtil callback for the Users list.
 */
class UserDiffCallback : DiffUtil.ItemCallback<Users>() {

    /**
     * Checks if two items are the same.
     * @param oldItem the old Users item.
     * @param newItem the new Users item.
     * @return true if the items are the same, false otherwise.
     */
    override fun areItemsTheSame(oldItem: Users, newItem: Users): Boolean {
        return oldItem.id == newItem.id
    }

    /**
     * Checks if the contents of two items are the same.
     * @param oldItem the old Users item.
     * @param newItem the new Users item.
     * @return true if the contents are the same, false otherwise.
     */
    override fun areContentsTheSame(oldItem: Users, newItem: Users): Boolean {
        return oldItem == newItem
    }
}