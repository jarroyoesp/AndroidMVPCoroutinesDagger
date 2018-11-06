package es.jarroyo.mvp_coroutines_dagger.app.di.module

import dagger.Module
import dagger.Provides
import es.jarroyo.mvp_coroutines_dagger.data.repository.GitHubRepository
import es.jarroyo.mvp_coroutines_dagger.data.source.disk.DiskDataSource
import es.jarroyo.mvp_coroutines_dagger.data.source.network.INetworkDataSource
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideForecastRepository(
        networkDataSource: INetworkDataSource,
        diskDataSource: DiskDataSource
    ) = GitHubRepository(networkDataSource, diskDataSource)
}