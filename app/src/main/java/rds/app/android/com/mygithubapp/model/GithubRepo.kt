package rds.app.android.com.mygithubapp.model

data class GithubRepo(
    var id: Int? = null,
    var name: String? = null,
    var owner: GithubUser? = null,
    var url: String? = null

)