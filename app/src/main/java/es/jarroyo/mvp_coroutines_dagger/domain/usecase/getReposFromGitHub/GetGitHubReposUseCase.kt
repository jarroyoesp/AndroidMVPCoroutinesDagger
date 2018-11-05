package es.jarroyo.mvp_coroutines_dagger.domain.usecase.getReposFromGitHub

import es.jarroyo.mvp_coroutines_dagger.data.repository.GitHubRepository
import es.jarroyo.mvp_coroutines_dagger.data.source.network.GithubAPI
import es.jarroyo.mvp_coroutines_dagger.domain.usecase.base.BaseUseCase

class GetGitHubReposUseCase(val repository: GitHubRepository): BaseUseCase<GetGitHubReposRequest, List<GithubAPI.Repo>>() {
    suspend override fun run(): List<GithubAPI.Repo> {
        return repository.getGitHubRepos(request!!)
    }

    /*suspend fun execute():List<GithubAPI.Repo> {
        return repository.getGitHubRepos()
    }*/
}