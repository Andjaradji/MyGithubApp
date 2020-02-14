package rds.app.android.com.mygithubapp.ui.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import rds.app.android.com.mygithubapp.databinding.UserFragmentBinding
import rds.app.android.com.mygithubapp.model.GithubUser
import rds.app.android.com.mygithubapp.model.network.GithubApi
import rds.app.android.com.mygithubapp.model.network.NetworkRepository


class UserFragment : Fragment() {

    private lateinit var adapter: UserListAdapter

    private lateinit var binding: UserFragmentBinding

    private lateinit var viewModel: UserViewModel

    private lateinit var viewModelFactory: UserViewModelFactory

    private val api = GithubApi.retrofitService

    private val repository = NetworkRepository(api)


    private val userList = ArrayList<GithubUser>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = UserFragmentBinding.inflate(inflater)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModelFactory = UserViewModelFactory(repository)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(UserViewModel::class.java)

        binding.lifecycleOwner = this
        adapter = UserListAdapter()
        binding.recyclerview.adapter = adapter

        viewModel.fetchUsers {
            setList(it)
        }

//        setList(viewModel.fetchUsers())
    }


    private fun setList(list: List<GithubUser>) {
        userList.clear()
        userList.addAll(list)
        adapter.submitList(userList)
        adapter.notifyDataSetChanged()
    }

}
