package es.jarroyo.mvp_coroutines_dagger.ui.home

import com.nhaarman.mockitokotlin2.whenever
import es.jarroyo.mvp_coroutines_dagger.app.navigator.Navigator
import es.jarroyo.mvp_coroutines_dagger.data.source.network.GithubAPI
import es.jarroyo.mvp_coroutines_dagger.domain.usecase.base.Response
import es.jarroyo.mvp_coroutines_dagger.domain.usecase.getGitHubContributors.GetGitHubContributorsUseCase
import es.jarroyo.mvp_coroutines_dagger.domain.usecase.getReposFromGitHub.GetGitHubReposRequest
import es.jarroyo.mvp_coroutines_dagger.domain.usecase.getReposFromGitHub.GetGitHubReposUseCase
import es.jarroyo.mvp_coroutines_dagger.ui.home.activity.HomePresenter
import es.jarroyo.mvp_coroutines_dagger.ui.home.activity.HomeView
import kotlinx.coroutines.Dispatchers.Unconfined
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.any
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class HomePresenterTest {
    @Mock
    lateinit var homeView: HomeView

    var navigator: Navigator = Navigator()

    @Mock
    lateinit var getGitHubReposUseCase: GetGitHubReposUseCase

    @Mock
    lateinit var getGitHubContributorsUseCase: GetGitHubContributorsUseCase

    lateinit var presenter: HomePresenter

    // DATA
    val testRepo = GithubAPI.Repo("TestRepo")
    val testRepoList = mutableListOf<GithubAPI.Repo>(testRepo)

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = createMockedPresenter()
    }

    @Test
    fun `should request the repository list from GitHub on start`() {
        runBlocking {
            presenter.initialize()
            Mockito.verify(getGitHubReposUseCase, Mockito.times(1)).execute(any())
        }
    }

    @Test
    fun `should show the repository list when repositories are received`() {
        runBlocking {
            val request = GetGitHubReposRequest("jarroyoesp")
            whenever(getGitHubReposUseCase.execute(request)).thenReturn(Response(testRepoList))

            presenter.initialize()

            Mockito.verify(homeView, Mockito.times(1))
                .onSuccessGetRepositories(testRepoList)
        }
    }

    @Test
    fun `should show empty repositories when repositories are received empty`() {
        runBlocking {
            val request = GetGitHubReposRequest("jarroyoesp")
            val emptyList = mutableListOf<GithubAPI.Repo>()
            whenever(getGitHubReposUseCase.execute(request)).thenReturn(Response(emptyList))

            presenter.initialize()

            Mockito.verify(homeView, Mockito.times(1))
                .onEmptyRepositories()
        }
    }


    private fun createMockedPresenter(): HomePresenter {
        val presenter = HomePresenter(homeView, navigator, getGitHubReposUseCase, getGitHubContributorsUseCase, Unconfined)
        return presenter
    }
}