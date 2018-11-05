package es.jarroyo.mvp_coroutines_dagger.ui.home.activity

import com.microhealth.lmc.ui.base.PresentationView
import es.jarroyo.mvp_coroutines_dagger.data.source.network.GithubAPI

interface HomeView: PresentationView {
    fun onSuccessGetRepositories(data: List<GithubAPI.Repo>)
    fun onErrorGetRepositories(message: String)

    fun onSuccessGetContributors(data: List<GithubAPI.Contributor>)
    fun onErrorGetContributors(message: String)
}