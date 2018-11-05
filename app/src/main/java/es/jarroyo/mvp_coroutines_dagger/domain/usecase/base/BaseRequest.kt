package es.jarroyo.mvp_coroutines_dagger.domain.usecase.base

interface BaseRequest {
    fun validate(): Boolean
}
