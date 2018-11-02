package es.jarroyo.mvp_coroutines_dagger.app.di.module

import dagger.Module
import dagger.Provides
import es.jarroyo.mvp_coroutines_dagger.data.repository.ForecastRepository
import es.jarroyo.mvp_coroutines_dagger.data.source.disk.DiskDataSource
import es.jarroyo.mvp_coroutines_dagger.data.source.network.NetworkDataSource
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideForecastRepository(networkDataSource: NetworkDataSource,
                                  diskDataSource: DiskDataSource) = ForecastRepository(networkDataSource, diskDataSource)
}