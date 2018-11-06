package es.jarroyo.mvp_coroutines_dagger.app.di.module

import com.microhealth.lmc.utils.NetworkSystemAbstract
import dagger.Module
import dagger.Provides
import es.jarroyo.mvp_coroutines_dagger.ui.App
import es.jarroyo.mvp_coroutines_dagger.utils.FakeNetworkSystem
import javax.inject.Singleton

@Module
class UtilsModule {
    @Provides
    @Singleton
    fun provideNetworkSystem(app: App) =
            FakeNetworkSystem(app) as NetworkSystemAbstract
}