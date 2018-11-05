package es.jarroyo.mvp_coroutines_dagger.data.source.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.microhealth.lmc.utils.NetworkSystemAbstract
import es.jarroyo.mvp_coroutines_dagger.domain.usecase.getReposFromGitHub.GetGitHubReposRequest
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkDataSource(private val networkSystem: NetworkSystemAbstract) {

    /**
     * GET GITHUB DATA
     */
    suspend fun getGitHubData(request: GetGitHubReposRequest): List<GithubAPI.Repo>{

        val retrofit = Retrofit.Builder().apply {
            baseUrl("https://api.github.com")
            addConverterFactory(GsonConverterFactory.create())
            addCallAdapterFactory(CoroutineCallAdapterFactory())
        }.build()

        val github = retrofit.create(GithubAPI::class.java)
        val contributors =
            github.listRepos(request.username)
                .await().take(10)
        return contributors
        //return github.users().await()
    }
}