package com.example.enfecdemo.view.fragments

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.enfecdemo.R
import com.example.enfecdemo.databinding.FragmentListBinding
import com.example.enfecdemo.utils.USER_DATA
import com.example.enfecdemo.utils.USER_ID
import com.example.enfecdemo.utils.USER_NAME
import com.example.enfecdemo.view.adapter.UsersListAdapter
import com.example.enfecdemo.viewModel.viewModels.ListViewModel


class ListFragment : Fragment(R.layout.fragment_list) {

    private lateinit var binding: FragmentListBinding
    private val viewModel by viewModels<ListViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize the binding object
        binding = FragmentListBinding.bind(view)

        // Sets up the RecyclerView using Kotlin's functional programming capabilities.
        binding.recyclerView.apply {
            this.layoutManager = LinearLayoutManager(this.context)
            this.adapter = UsersListAdapter { user ->
                val bundle = bundleOf(USER_ID to user.id,
                    USER_NAME to user.name)
                findNavController().navigate(R.id.action_listFragment_to_detailFragment, bundle)
            }
            // This a simple divider between each list item in the RecyclerView
            this.addItemDecoration(
                DividerItemDecoration(
                    this.context,
                    (this.layoutManager as LinearLayoutManager).orientation
                )
            )
    }

        /**
         * Observes the LiveData<List<Employee>> from the ViewModel. Any time this object updates,
         * the code within the lambda will be executed with the most current data.
         */
        viewModel.usersListLiveData.observe(viewLifecycleOwner) { userList ->

            binding.cardViewListLoading.visibility = when {
                userList.isEmpty() -> View.VISIBLE
                else -> View.GONE
            }
            /**
             * Get the adapter from recyclerView and cast it to the correct class and then pass it
             * the update List.
             */
            (binding.recyclerView.adapter as UsersListAdapter).submitList(userList)
            }
        }
}