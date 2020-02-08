package rds.app.android.com.mygithubapp.model

import com.google.gson.annotations.SerializedName


data class GithubUser(
    var id: Long = 0,
    var login: String? = null,
    var url: String? = null,
    var name: String? = null,
    @SerializedName("avatar_url")
    var avatarUrl: String? = null,
    @SerializedName("html_url")
    var htmlUrl: String? = null,
    @SerializedName("followers_url")
    var followersUrl: String? = null,
    @SerializedName("following_url")
    var followingUrl: String? = null,
    @SerializedName("gists_url")
    var gistsUrl: String? = null,
    @SerializedName("starred_url")
    var starredUrl: String? = null,
    @SerializedName("subscriptions_url")
    var subscriptionsUrl: String? = null,
    @SerializedName("organizations_url")
    var organizationsUrl: String? = null,
    @SerializedName("repos_url")
    var reposUrl: String? = null
)

