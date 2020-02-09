package rds.app.android.com.mygithubapp.ui.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import rds.app.android.com.mygithubapp.databinding.UserFragmentBinding
import rds.app.android.com.mygithubapp.model.GithubUser


class UserFragment : Fragment() {

    private lateinit var adapter: UserListAdapter

    private lateinit var binding: UserFragmentBinding

    private lateinit var viewModel: UserViewModel


    private val userList = ArrayList<GithubUser>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = UserFragmentBinding.inflate(inflater)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)

        binding.lifecycleOwner = this
        adapter = UserListAdapter()
        binding.recyclerview.adapter = adapter

        viewModel.fetchUsers {
            setList(it)
        }
    }


    private fun setList(list: List<GithubUser>) {
        userList.clear()
        userList.addAll(list)
        adapter.submitList(userList)
        adapter.notifyDataSetChanged()
    }

}
