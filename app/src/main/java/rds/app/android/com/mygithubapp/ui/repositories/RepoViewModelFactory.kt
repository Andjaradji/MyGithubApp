package rds.app.android.com.mygithubapp.ui.repositories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import rds.app.android.com.mygithubapp.model.network.NetworkRepository

class RepoViewModelFactory(private val repository: NetworkRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RepoViewModel::class.java)) {
            return RepoViewModel(
                repository
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}