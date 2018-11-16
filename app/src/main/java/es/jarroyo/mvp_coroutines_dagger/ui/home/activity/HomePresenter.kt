package es.jarroyo.mvp_coroutines_dagger.ui.home.activity

import com.microhealth.lmc.ui.base.Presenter
import es.jarroyo.mvp_coroutines_dagger.app.navigator.Navigator
import es.jarroyo.mvp_coroutines_dagger.data.source.network.GithubAPI
import es.jarroyo.mvp_coroutines_dagger.domain.usecase.getGitHubContributors.GetGitHubContributorsRequest
import es.jarroyo.mvp_coroutines_dagger.domain.usecase.getGitHubContributors.GetGitHubContributorsUseCase
import es.jarroyo.mvp_coroutines_dagger.domain.usecase.getReposFromGitHub.GetGitHubReposRequest
import es.jarroyo.mvp_coroutines_dagger.domain.usecase.getReposFromGitHub.GetGitHubReposUseCase
import es.jarroyo.mvp_coroutines_dagger.utils.launchSilent
import kotlin.coroutines.CoroutineContext

class HomePresenter(
    override val view: HomeView,
    override val navigator: Navigator,
    val getGitHubReposUseCase: GetGitHubReposUseCase,
    val getGitHubContributorsUseCase: GetGitHubContributorsUseCase,
    private val coroutineContext: CoroutineContext

) : Presenter<HomeView> {

    override fun initialize() {
        getRepositoriesList()
    }

    /**
     * GET REPOSITORIES FROM GITHUB
     */
    fun getRepositoriesList() = launchSilent(coroutineContext) {
            val request = GetGitHubReposRequest("jarroyoesp")
            val result = getGitHubReposUseCase.execute(request)
            if (result != null && result.error == null && result.data != null) {
                onSuccesGetRepositoriesList(result.data!!)
            } else if (result != null && result.error != null) {
                view.onErrorGetContributors(result.error!!)
            }
    }

    fun onSuccesGetRepositoriesList(repositoriesList: List<GithubAPI.Repo>) {
        if (repositoriesList.isNullOrEmpty()) {
            view.onEmptyRepositories()
        } else {
            view.onSuccessGetRepositories(repositoriesList)
            getContributors("jarroyoesp", repositoriesList.get(0).name)
        }
    }

    /**
     * GET CONTRIBUTORS FFROM REPOSITORY
     */
    fun getContributors(owner: String, repositorieName: String) = launchSilent(coroutineContext) {
            val request2 = GetGitHubContributorsRequest(owner, repositorieName)
            val result2 = getGitHubContributorsUseCase.execute(request2)
            if (result2 != null && result2.error == null && result2.data != null) {
                view.onSuccessGetContributors(result2.data!!)
            } else if (result2 != null && result2.error != null) {
                view.onErrorGetContributors(result2.error!!)
            }
    }

    override fun clearView() {
    }
}