package es.jarroyo.mvp_coroutines_dagger.app.di.module


import dagger.Module
import dagger.Provides
import es.jarroyo.mvp_coroutines_dagger.app.navigator.Navigator
import es.jarroyo.mvp_coroutines_dagger.ui.App
import javax.inject.Singleton


@Module
class ApplicationModule(val app: App){
    @Provides @Singleton
    fun provideApp(): App = app

    @Provides @Singleton
    fun provideNavigator(): Navigator = Navigator()

/*    @Provides @Singleton
    fun provideMainThread(): MainThread = MainThreadImpl()

    @Provides @Singleton
    fun provideThreadExecutor(): UseCaseExecutor = ThreadExecutor()*/

}