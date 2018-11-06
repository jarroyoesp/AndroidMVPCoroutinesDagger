package es.jarroyo.mvp_coroutines_dagger.ui

import android.app.Application
import es.jarroyo.mvp_coroutines_dagger.app.di.component.ApplicationComponent
import es.jarroyo.mvp_coroutines_dagger.app.di.component.DaggerApplicationComponent
import es.jarroyo.mvp_coroutines_dagger.app.di.module.ApplicationModule

open class App : Application() {
    companion object {
        lateinit var graph: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        initializeDagger()
    }

    private fun initializeDagger() {
        graph = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }

    fun getApplicationComponent() = graph
}