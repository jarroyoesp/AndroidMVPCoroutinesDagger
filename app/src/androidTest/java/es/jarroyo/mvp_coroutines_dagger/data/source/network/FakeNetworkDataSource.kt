package es.jarroyo.mvp_coroutines_dagger.data.source.network

import com.microhealth.lmc.data.exception.NetworkConnectionException
import com.microhealth.lmc.utils.NetworkSystemAbstract
import es.jarroyo.mvp_coroutines_dagger.domain.usecase.getGitHubContributors.GetGitHubContributorsRequest
import es.jarroyo.mvp_coroutines_dagger.domain.usecase.getReposFromGitHub.GetGitHubReposRequest

class FakeNetworkDataSource(private val networkSystem: NetworkSystemAbstract) : INetworkDataSource(networkSystem) {

    /**
     * GET GITHUB DATA
     */
    override suspend fun getGitHubData(request: GetGitHubReposRequest): List<GithubAPI.Repo> {

        if (networkSystem.isNetworkAvailable()) {
            return mutableListOf()
        } else {
            throw NetworkConnectionException()
        }
    }

    /**
     * GET GITHUB DATA
     */
    override suspend fun getGitHubContributors(request: GetGitHubContributorsRequest): List<GithubAPI.Contributor> {

        if (networkSystem.isNetworkAvailable()) {
            return mutableListOf()
        } else {
            throw NetworkConnectionException()
        }
    }
}