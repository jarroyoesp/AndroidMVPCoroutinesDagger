package es.jarroyo.mvp_coroutines_dagger.ui.home.activity

import android.os.Bundle
import es.jarroyo.mvp_coroutines_dagger.R
import es.jarroyo.mvp_coroutines_dagger.app.di.component.ApplicationComponent
import es.jarroyo.mvp_coroutines_dagger.app.di.subcomponent.home.activity.HomeActivityModule
import es.jarroyo.mvp_coroutines_dagger.data.source.network.GithubAPI
import es.jarroyo.mvp_coroutines_dagger.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_home.*
import javax.inject.Inject

class HomeActivity : BaseActivity(), HomeView {
    override var layoutId = R.layout.activity_home

    @Inject
    lateinit var presenter: HomePresenter

    override fun setupInjection(applicationComponent: ApplicationComponent) {
        applicationComponent.plus(HomeActivityModule(this)).injectTo(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter.initialize()
    }

    /**
     * PRESENTATION VIEW
     */
    override fun onSuccessGetRepositories(data: List<GithubAPI.Repo>) {
        var text = ""
        for (repo in data) {
            text = "$text\n${repo.name}"
        }
        activity_home_tv_title.text = text
    }

    override fun onErrorGetRepositories(message: String) {
        activity_home_tv_title.text = message
    }

    override fun onSuccessGetContributors(data: List<GithubAPI.Contributor>) {
        var text = ""
        for (contributor in data) {
            text = "$text\n${contributor.login}"
        }
        activity_home_tv_contributors.text = text
    }

    override fun onErrorGetContributors(message: String) {
        activity_home_tv_contributors.text = message
    }

    override fun onEmptyRepositories() {
        activity_home_tv_contributors.text = "EMPTY_REPOSITORIES"
    }
}
