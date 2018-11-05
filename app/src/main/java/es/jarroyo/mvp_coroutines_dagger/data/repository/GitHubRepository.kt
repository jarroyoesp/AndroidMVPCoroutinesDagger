package es.jarroyo.mvp_coroutines_dagger.data.repository


import es.jarroyo.mvp_coroutines_dagger.data.source.disk.DiskDataSource
import es.jarroyo.mvp_coroutines_dagger.data.source.network.GithubAPI
import es.jarroyo.mvp_coroutines_dagger.data.source.network.NetworkDataSource
import es.jarroyo.mvp_coroutines_dagger.domain.usecase.getGitHubContributors.GetGitHubContributorsRequest
import es.jarroyo.mvp_coroutines_dagger.domain.usecase.getReposFromGitHub.GetGitHubReposRequest

class GitHubRepository(private val networkDataSource: NetworkDataSource,
                       private val diskDataSource: DiskDataSource
) {

    val TAG = GitHubRepository::class.java.simpleName


    /***********************************************************************************************
     * GET REPOSITORIES LIST
     **********************************************************************************************/
    suspend fun getGitHubRepos(request: GetGitHubReposRequest): List<GithubAPI.Repo> {
        val result = networkDataSource.getGitHubData(request)
        return result
    }

    /***********************************************************************************************
     * GET CONTRIBUTORS LIST
     **********************************************************************************************/
    suspend fun getGitHubContributors(request: GetGitHubContributorsRequest): List<GithubAPI.Contributor> {
        val result = networkDataSource.getGitHubContributors(request)
        return result
    }
}