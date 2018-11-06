package es.jarroyo.mvp_coroutines_dagger.domain.usecase.getReposFromGitHub

import com.microhealth.lmc.data.exception.NetworkConnectionException
import es.jarroyo.mvp_coroutines_dagger.data.repository.GitHubRepository
import es.jarroyo.mvp_coroutines_dagger.data.source.network.GithubAPI
import es.jarroyo.mvp_coroutines_dagger.domain.usecase.base.BaseUseCase
import es.jarroyo.mvp_coroutines_dagger.domain.usecase.base.Response
import retrofit2.HttpException

class GetGitHubReposUseCase(val repository: GitHubRepository) : BaseUseCase<GetGitHubReposRequest, List<GithubAPI.Repo>>() {

    override suspend fun run(): Response<List<GithubAPI.Repo>> {
        try {
            return Response(repository.getGitHubRepos(request!!))
        } catch (e: NetworkConnectionException) {
            return Response(error = "NetworkConnectionException", exception = e)
        } catch (e: HttpException) {
            return Response(error = "HttpException", exception = e)
        }
    }
}