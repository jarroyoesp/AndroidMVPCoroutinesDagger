package es.jarroyo.mvp_coroutines_dagger.app.di.module

import com.microhealth.lmc.utils.NetworkSystemAbstract
import dagger.Module
import dagger.Provides
import es.jarroyo.mvp_coroutines_dagger.data.source.disk.DiskDataSource
import es.jarroyo.mvp_coroutines_dagger.data.source.network.FakeNetworkDataSource
import es.jarroyo.mvp_coroutines_dagger.data.source.network.INetworkDataSource
import es.jarroyo.mvp_coroutines_dagger.ui.App
import javax.inject.Singleton

@Module
class DataModule {

    @Provides @Singleton
    fun provideDiskDataSource(appContext: App) =
            DiskDataSource(appContext)

    @Provides @Singleton
    fun provideNetworkDataSource(networkSystemBase: NetworkSystemAbstract) =
            FakeNetworkDataSource(networkSystemBase) as INetworkDataSource
}
