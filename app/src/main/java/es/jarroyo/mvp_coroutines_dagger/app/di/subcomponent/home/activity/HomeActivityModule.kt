package es.jarroyo.mvp_coroutines_dagger.app.di.subcomponent.home.activity

import dagger.Module
import dagger.Provides
import es.jarroyo.mvp_coroutines_dagger.app.di.module.ActivityModule
import es.jarroyo.mvp_coroutines_dagger.app.navigator.Navigator
import es.jarroyo.mvp_coroutines_dagger.domain.usecase.getGitHubContributors.GetGitHubContributorsUseCase
import es.jarroyo.mvp_coroutines_dagger.domain.usecase.getReposFromGitHub.GetGitHubReposUseCase
import es.jarroyo.mvp_coroutines_dagger.ui.home.activity.HomeActivity
import es.jarroyo.mvp_coroutines_dagger.ui.home.activity.HomePresenter
import es.jarroyo.mvp_coroutines_dagger.ui.home.activity.HomeView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

@Module
class HomeActivityModule(activity: HomeActivity) : ActivityModule(activity) {

    @Provides
    fun provideView(): HomeView = activity as HomeView

    @Provides
    fun providesJob() = Job()

    @Provides
    fun provideCoroutineContext(): CoroutineContext = Dispatchers.Main


    @Provides
    fun providePresenter(
        view: HomeView,
        navigator: Navigator,
        getGitHubReposUseCase: GetGitHubReposUseCase,
        getGitHubContributorsUseCase: GetGitHubContributorsUseCase,
        coroutineContext: CoroutineContext,
        job: Job
    ) = HomePresenter(view, navigator, getGitHubReposUseCase, getGitHubContributorsUseCase, coroutineContext, job)
}