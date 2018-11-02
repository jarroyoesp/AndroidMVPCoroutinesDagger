package es.jarroyo.mvp_coroutines_dagger.app.di.component

import dagger.Component
import es.jarroyo.mvp_coroutines_dagger.app.di.module.ApplicationModule
import es.jarroyo.mvp_coroutines_dagger.app.di.module.DataModule
import es.jarroyo.mvp_coroutines_dagger.app.di.module.RepositoryModule
import es.jarroyo.mvp_coroutines_dagger.app.di.module.UtilsModule
import es.jarroyo.mvp_coroutines_dagger.app.di.subcomponent.home.activity.HomeActivityComponent
import es.jarroyo.mvp_coroutines_dagger.app.di.subcomponent.home.activity.HomeActivityModule
import javax.inject.Singleton


@Singleton
@Component(
    modules = arrayOf(
        ApplicationModule::class,
        UtilsModule::class,
        RepositoryModule::class,
        DataModule::class
    )
)
interface ApplicationComponent {
    /**
     * UI - ACTIVITY
     */
    fun plus(module: HomeActivityModule): HomeActivityComponent
}