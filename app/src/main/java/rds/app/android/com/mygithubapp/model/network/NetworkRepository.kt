package rds.app.android.com.mygithubapp.model.network

import android.util.Log
import rds.app.android.com.mygithubapp.model.GithubUser
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class NetworkRepository(private val api: NetworkService) {
    private val LOG_TAG = "TAG for TESTING"

    fun getUsers(): List<GithubUser>? {
        var data: List<GithubUser>? = listOf()

        api.getGithubUsers().enqueue(object : Callback<List<GithubUser>?> {
            override fun onFailure(call: Call<List<GithubUser>?>, t: Throwable) {
                Log.d(LOG_TAG, "Failure Fetch")
            }

            override fun onResponse(
                call: Call<List<GithubUser>?>,
                response: Response<List<GithubUser>?>
            ) {
                data = response.body()
            }

        })
        return data
    }
}