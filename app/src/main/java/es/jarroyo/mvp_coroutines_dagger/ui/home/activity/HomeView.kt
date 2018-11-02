package es.jarroyo.mvp_coroutines_dagger.ui.home.activity

import com.microhealth.lmc.ui.base.PresentationView
import es.jarroyo.mvp_coroutines_dagger.data.source.network.GithubAPI

interface HomeView: PresentationView {
    fun showData(data: List<GithubAPI.Repo>)
}