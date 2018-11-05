package es.jarroyo.mvp_coroutines_dagger.app.di.module

import dagger.Module
import dagger.Provides
import es.jarroyo.mvp_coroutines_dagger.data.repository.GitHubRepository
import es.jarroyo.mvp_coroutines_dagger.domain.usecase.getGitHubContributors.GetGitHubContributorsUseCase
import es.jarroyo.mvp_coroutines_dagger.domain.usecase.getReposFromGitHub.GetGitHubReposUseCase
import javax.inject.Singleton

@Module
class DomainModule {

    @Provides
    @Singleton
    fun provideGetGitHubReposUseCase(repository: GitHubRepository) = GetGitHubReposUseCase(repository)

    @Provides
    @Singleton
    fun provideGetGitHubContributorsUseCase(repository: GitHubRepository) = GetGitHubContributorsUseCase(repository)
}