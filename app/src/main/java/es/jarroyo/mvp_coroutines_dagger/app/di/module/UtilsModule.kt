package es.jarroyo.mvp_coroutines_dagger.app.di.module


import com.microhealth.lmc.utils.NetworkSystem
import com.microhealth.lmc.utils.NetworkSystemAbstract
import dagger.Module
import dagger.Provides
import es.jarroyo.mvp_coroutines_dagger.ui.App
import javax.inject.Singleton

@Module
class UtilsModule {
    @Provides
    @Singleton
    fun provideNetworkSystem(app: App)
            = NetworkSystem(app) as NetworkSystemAbstract
}