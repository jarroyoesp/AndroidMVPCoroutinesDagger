package es.jarroyo.mvp_coroutines_dagger.ui.home.activity

import com.microhealth.lmc.ui.base.Presenter
import es.jarroyo.mvp_coroutines_dagger.app.navigator.Navigator
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

    fun getData() {
        uiScope.launch {
            val request = GetGitHubReposRequest("jarroyoesp")
            val result = getGitHubReposUseCase.execute(request)
            if (result.error == null && result.data != null) {
                view.showData(result.data!!)
            } else if (result.error != null) {
                view.showError(result.error!!)
            }


            val request2 = GetGitHubContributorsRequest("jarroyoesp", "tensorFlow")
            val result2 = getGitHubContributorsUseCase.execute(request2)
            if (result2.error == null && result2.data != null) {
                view.onSuccessGetContributors(result2.data!!)
            } else if (result.error != null) {
                view.onErrorGetContributors(result.error!!)
            }

        }
    }


    override fun clearView() {
    }
}