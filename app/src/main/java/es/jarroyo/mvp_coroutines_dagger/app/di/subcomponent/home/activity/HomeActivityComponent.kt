package es.jarroyo.mvp_coroutines_dagger.app.di.subcomponent.home.activity

import dagger.Subcomponent
import es.jarroyo.mvp_coroutines_dagger.ui.home.activity.HomeActivity

@Subcomponent(modules = arrayOf(HomeActivityModule::class))
interface HomeActivityComponent {
    fun injectTo(activity: HomeActivity)
}