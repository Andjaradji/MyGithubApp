package rds.app.android.com.mygithubapp.ui.user

import androidx.lifecycle.ViewModel
import rds.app.android.com.mygithubapp.model.GithubUser
import rds.app.android.com.mygithubapp.model.network.NetworkRepository

class UserViewModel(repository: NetworkRepository) : ViewModel() {

    private val mRepository = repository

    fun fetchUsers(callback: (userList: List<GithubUser>) -> Any) {
        mRepository.fetchUsers {
            callback(it)
        }
    }

}




