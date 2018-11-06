package es.jarroyo.mvp_coroutines_dagger.ui

import es.jarroyo.mvp_coroutines_dagger.app.di.component.DaggerTestApplicationComponent
import es.jarroyo.mvp_coroutines_dagger.app.di.component.TestApplicationComponent
import es.jarroyo.mvp_coroutines_dagger.app.di.module.TestApplicationModule

open class TestApp : App() {
    companion object {
        lateinit var graph: TestApplicationComponent
    }

    override fun onCreate() {
        // super.onCreate()
        initializeDagger()
    }

    private fun initializeDagger() {
        graph = DaggerTestApplicationComponent.builder()
                .testApplicationModule(TestApplicationModule(this))
                .build()
    }
}