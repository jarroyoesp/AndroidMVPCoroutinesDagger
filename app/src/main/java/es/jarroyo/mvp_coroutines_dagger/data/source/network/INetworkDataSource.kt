package es.jarroyo.mvp_coroutines_dagger.data.source.network

import com.microhealth.lmc.utils.NetworkSystemAbstract
import es.jarroyo.mvp_coroutines_dagger.domain.usecase.getGitHubContributors.GetGitHubContributorsRequest
import es.jarroyo.mvp_coroutines_dagger.domain.usecase.getReposFromGitHub.GetGitHubReposRequest

open abstract class INetworkDataSource(private val networkSystem: NetworkSystemAbstract) {

    /**
     * GET GITHUB DATA
     */
    abstract suspend fun getGitHubData(request: GetGitHubReposRequest): List<GithubAPI.Repo>

    /**
     * GET GITHUB DATA
     */
    abstract suspend fun getGitHubContributors(request: GetGitHubContributorsRequest): List<GithubAPI.Contributor>
}