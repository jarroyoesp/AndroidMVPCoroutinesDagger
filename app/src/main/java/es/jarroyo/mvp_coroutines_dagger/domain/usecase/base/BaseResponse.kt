package es.jarroyo.mvp_coroutines_dagger.domain.usecase.base

interface BaseResponse {

    fun onNetworkConnectionError()

    fun onNetworkServiceError()

    fun onUnknownError()

    fun onIllegalStateError(message: String)
}
