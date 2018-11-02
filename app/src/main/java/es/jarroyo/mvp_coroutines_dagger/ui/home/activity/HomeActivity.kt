package es.jarroyo.mvp_coroutines_dagger.ui.home.activity

import android.os.Bundle
import es.jarroyo.mvp_coroutines_dagger.R
import es.jarroyo.mvp_coroutines_dagger.app.di.component.ApplicationComponent
import es.jarroyo.mvp_coroutines_dagger.app.di.subcomponent.home.activity.HomeActivityModule
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

        presenter.getData()
    }

    /**
     * PRESENTATION VIEW
     */
    override fun showData(data: String) {
        activity_home_tv_title.text = data
    }

}
