package es.jarroyo.mvp_coroutines_dagger.ui.home.activity

import com.microhealth.lmc.ui.base.Presenter
import es.jarroyo.mvp_coroutines_dagger.app.navigator.Navigator
import es.jarroyo.mvp_coroutines_dagger.data.source.network.GithubAPI
import es.jarroyo.mvp_coroutines_dagger.domain.usecase.getGitHubContributors.GetGitHubContributorsRequest
import es.jarroyo.mvp_coroutines_dagger.domain.usecase.getGitHubContributors.GetGitHubContributorsUseCase
import es.jarroyo.mvp_coroutines_dagger.domain.usecase.getReposFromGitHub.GetGitHubReposRequest
import es.jarroyo.mvp_coroutines_dagger.domain.usecase.getReposFromGitHub.GetGitHubReposUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class HomePresenter(
    override val view: HomeView,
    override val navigator: Navigator,
    val getGitHubReposUseCase: GetGitHubReposUseCase,
    val getGitHubContributorsUseCase: GetGitHubContributorsUseCase
) : Presenter<HomeView> {

    /**
     * This is the job for all coroutines started by this Presenter.
     * Cancelling this job will cancel all coroutines started by this Presenter.
     */
    private val presenterJob = Job()

    /**
     * This is the main scope for all coroutines launched by Presenter.
     *
     * Since we pass viewModelJob, you can cancel all coroutines launched by uiScope by calling
     * presenterJob.cancel()
     */
    private val uiScope = CoroutineScope(Dispatchers.Main + presenterJob)

    /**
     * GET REPOSITORIES FROM GITHUB
     */
    fun getRepositoriesList() {
        uiScope.launch {
            val request = GetGitHubReposRequest("jarroyoesp")
            val result = getGitHubReposUseCase.execute(request)
            if (result.error == null && result.data != null) {
                onSuccesGetRepositoriesList(result.data!!)
            } else if (result.error != null) {
                view.onErrorGetContributors(result.error!!)
            }
        }
    }

    fun onSuccesGetRepositoriesList(repositoriesList: List<GithubAPI.Repo>) {
        view.onSuccessGetRepositories(repositoriesList)
        getContributors("jarroyoesp", repositoriesList.get(0).name)
    }

    /**
     * GET CONTRIBUTORS FFROM REPOSITORY
     */
    fun getContributors(owner: String, repositorieName: String) {
        uiScope.launch {
            val request2 = GetGitHubContributorsRequest(owner, repositorieName)
            val result2 = getGitHubContributorsUseCase.execute(request2)
            if (result2.error == null && result2.data != null) {
                view.onSuccessGetContributors(result2.data!!)
            } else if (result2.error != null) {
                view.onErrorGetContributors(result2.error!!)
            }
        }
    }

    override fun clearView() {
    }
}