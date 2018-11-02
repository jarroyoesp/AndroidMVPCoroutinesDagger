package es.jarroyo.mvp_coroutines_dagger.domain.usecase.getReposFromGitHub

import es.jarroyo.mvp_coroutines_dagger.data.repository.ForecastRepository
import es.jarroyo.mvp_coroutines_dagger.data.source.network.GithubAPI

class GetGitHubReposUseCase(val repository: ForecastRepository) {

    suspend fun execute():List<GithubAPI.Repo> {
        return repository.getForecastData()
    }
}