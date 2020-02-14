package rds.app.android.com.mygithubapp.model.network

import rds.app.android.com.mygithubapp.model.GithubRepo
import rds.app.android.com.mygithubapp.model.GithubUser
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class NetworkRepository(private val api: NetworkService) {
    private val LOG_TAG = "TAG for TESTING"
    private val getUser = api.getGithubUsers()
    private val getRepo = api.getGithubRepos()

    fun fetchUsers(callback: (userList: List<GithubUser>) -> Any) {
        var githubUsers: List<GithubUser>

        getUser.enqueue(object : Callback<List<GithubUser>> {

            override fun onResponse(
                call: Call<List<GithubUser>>?,
                response: Response<List<GithubUser>>?
            ) {
                response?.body().let {
                    githubUsers = it!!
                }
                callback(githubUsers)
            }

            override fun onFailure(call: Call<List<GithubUser>>?, t: Throwable?) {
            }
        })
    }

    fun fetchRepo(callback: (repoList: List<GithubRepo>) -> Any) {
        var githubRepo: List<GithubRepo>

        getRepo.enqueue(object : Callback<List<GithubRepo>> {

            override fun onResponse(
                call: Call<List<GithubRepo>>?,
                response: Response<List<GithubRepo>>?
            ) {
                response?.body().let {
                    githubRepo = it!!
                }
                callback(githubRepo)
            }

            override fun onFailure(call: Call<List<GithubRepo>>?, t: Throwable?) {
            }
        })
    }
}