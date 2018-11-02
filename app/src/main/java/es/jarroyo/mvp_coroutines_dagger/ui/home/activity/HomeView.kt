package es.jarroyo.mvp_coroutines_dagger.ui.home.activity

import com.microhealth.lmc.ui.base.PresentationView

interface HomeView: PresentationView {
    fun showData(data: String)
}