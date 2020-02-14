package rds.app.android.com.mygithubapp.ui.user

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import rds.app.android.com.mygithubapp.model.network.NetworkRepository

class UserViewModelFactory(private val repository: NetworkRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            return UserViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}