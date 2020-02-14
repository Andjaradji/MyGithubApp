package rds.app.android.com.mygithubapp.ui.repositories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import rds.app.android.com.mygithubapp.databinding.RepoFragmentBinding
import rds.app.android.com.mygithubapp.model.GithubRepo
import rds.app.android.com.mygithubapp.model.network.GithubApi
import rds.app.android.com.mygithubapp.model.network.NetworkRepository

class RepoFragment : Fragment() {


    private lateinit var viewModel: RepoViewModel

    private lateinit var adapter: RepoListAdapter

    private lateinit var binding: RepoFragmentBinding

    private lateinit var repoViewModelFactory: RepoViewModelFactory

    private val api = GithubApi.retrofitService

    private val repository = NetworkRepository(api)

    private val repoList = ArrayList<GithubRepo>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = RepoFragmentBinding.inflate(inflater)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        repoViewModelFactory =
            RepoViewModelFactory(
                repository
            )
        viewModel = ViewModelProviders.of(this, repoViewModelFactory).get(RepoViewModel::class.java)
        binding.lifecycleOwner = this
        adapter = RepoListAdapter()
        binding.recyclerview.adapter = adapter

        viewModel.fetchRepo {
            setList(it)
        }
    }

    private fun setList(list: List<GithubRepo>) {
        repoList.clear()
        repoList.addAll(list)
        adapter.submitList(repoList)
        adapter.notifyDataSetChanged()
    }

}
