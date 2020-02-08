package rds.app.android.com.mygithubapp

import androidx.lifecycle.ViewModel
import rds.app.android.com.mygithubapp.model.GithubUser
import rds.app.android.com.mygithubapp.model.network.NetworkRepository

class UserViewModel(private val repository: NetworkRepository) : ViewModel() {


    val result: List<GithubUser>? = repository.getUsers()


}
