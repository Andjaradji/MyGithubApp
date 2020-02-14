package rds.app.android.com.mygithubapp.ui.repositories

import androidx.lifecycle.ViewModel
import rds.app.android.com.mygithubapp.model.GithubRepo
import rds.app.android.com.mygithubapp.model.network.NetworkRepository

class RepoViewModel(repository: NetworkRepository) : ViewModel() {

    private val mRepository = repository

    fun fetchRepo(callback: (repoList: List<GithubRepo>) -> Any) {
        mRepository.fetchRepo {
            callback(it)
        }
    }

}
