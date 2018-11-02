package es.jarroyo.mvp_coroutines_dagger.app.di.subcomponent.home.activity

import dagger.Module
import dagger.Provides
import es.jarroyo.mvp_coroutines_dagger.app.di.module.ActivityModule
import es.jarroyo.mvp_coroutines_dagger.app.navigator.Navigator
import es.jarroyo.mvp_coroutines_dagger.ui.home.activity.HomeActivity
import es.jarroyo.mvp_coroutines_dagger.ui.home.activity.HomePresenter
import es.jarroyo.mvp_coroutines_dagger.ui.home.activity.HomeView

@Module
class HomeActivityModule(activity: HomeActivity) : ActivityModule(activity) {

    @Provides
    fun provideView(): HomeView = activity as HomeView

    @Provides
    fun providePresenter(view: HomeView,
                               navigator: Navigator)
            = HomePresenter(view, navigator)


}