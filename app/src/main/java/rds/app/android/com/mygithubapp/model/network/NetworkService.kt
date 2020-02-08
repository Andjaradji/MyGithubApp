package rds.app.android.com.mygithubapp.model.network

import rds.app.android.com.mygithubapp.model.GithubUser
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .build()

interface NetworkService {

    @GET("users")
    fun getGithubUsers(): Call<List<GithubUser>>

}

object GithubApi {
    val retrofitService: NetworkService by lazy {
        retrofit.create(NetworkService::class.java)
    }
}