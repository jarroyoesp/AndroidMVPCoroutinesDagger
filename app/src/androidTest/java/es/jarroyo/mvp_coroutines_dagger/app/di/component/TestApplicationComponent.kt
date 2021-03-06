package es.jarroyo.mvp_coroutines_dagger.app.di.component

import dagger.Component
import es.jarroyo.mvp_coroutines_dagger.app.di.module.*
import es.jarroyo.mvp_coroutines_dagger.app.di.subcomponent.home.activity.HomeActivityComponent
import es.jarroyo.mvp_coroutines_dagger.app.di.subcomponent.home.activity.HomeActivityModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = arrayOf(
        TestApplicationModule::class,
        UtilsModule::class,
        RepositoryModule::class,
        DataModule::class,
        DomainModule::class
    )
)
interface TestApplicationComponent {
    /**
     * UI - ACTIVITY
     */
    fun plus(module: HomeActivityModule): HomeActivityComponent
}