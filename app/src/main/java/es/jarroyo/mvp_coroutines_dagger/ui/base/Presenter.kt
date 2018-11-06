package com.microhealth.lmc.ui.base

import es.jarroyo.mvp_coroutines_dagger.app.navigator.Navigator
import es.jarroyo.mvp_coroutines_dagger.domain.usecase.base.BaseResponse

interface Presenter<out T : PresentationView> :
    BaseResponse {

    val view: T
    val navigator: Navigator

    fun clearView()

    override fun onNetworkConnectionError() {
        clearView()
    }

    override fun onNetworkServiceError() {
        clearView()
    }

    override fun onUnknownError() {
        clearView()
    }

    override fun onIllegalStateError(message: String) {
        clearView()
    }
}