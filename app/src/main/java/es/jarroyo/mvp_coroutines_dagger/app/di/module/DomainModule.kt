package es.jarroyo.mvp_coroutines_dagger.app.di.module

import dagger.Module
import dagger.Provides
import es.jarroyo.mvp_coroutines_dagger.data.repository.ForecastRepository
import es.jarroyo.mvp_coroutines_dagger.domain.usecase.getReposFromGitHub.GetGitHubReposUseCase
import javax.inject.Singleton

@Module
class DomainModule {

    @Provides
    @Singleton
    fun provideGetGitHubReposUseCase(repository: ForecastRepository) = GetGitHubReposUseCase(repository)
}