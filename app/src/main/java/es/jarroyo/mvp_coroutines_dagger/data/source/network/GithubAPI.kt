package es.jarroyo.mvp_coroutines_dagger.data.source.network

import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubAPI {

    @GET("/repos/{owner}/{repo}/contributors")
    fun contributors(
        @Path("owner") owner: String,
        @Path("repo") repo: String
    ): Deferred<List<Contributor>>

    @GET("users/{user}/repos")
    fun listRepos(@Path("user") user: String): Deferred<List<Repo>>

    @GET("/users/defunkt")
    fun users(): Deferred<String>

    data class Contributor(val login: String, val contributions: Int)
    data class Repo(val name: String)
}