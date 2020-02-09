package rds.app.android.com.mygithubapp.ui.user

import androidx.lifecycle.ViewModel
import rds.app.android.com.mygithubapp.model.GithubUser
import rds.app.android.com.mygithubapp.model.network.GithubApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserViewModel : ViewModel() {


    fun fetchUsers(callback: (userList: List<GithubUser>) -> Any) {
        val call = GithubApi.retrofitService.getGithubUsers()
        var githubUsers: List<GithubUser>


        call.enqueue(object : Callback<List<GithubUser>> {

            override fun onResponse(
                call: Call<List<GithubUser>>?,
                response: Response<List<GithubUser>>?
            ) {
                githubUsers = response?.body()!!
                callback(githubUsers)
            }

            override fun onFailure(call: Call<List<GithubUser>>?, t: Throwable?) {
            }
        })
    }
}




