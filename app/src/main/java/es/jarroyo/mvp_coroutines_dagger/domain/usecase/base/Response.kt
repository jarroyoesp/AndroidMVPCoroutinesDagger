package es.jarroyo.mvp_coroutines_dagger.domain.usecase.base


class Response<T>(var data: T? = null,
                  var error: String? = null,
                  var exception: Exception? = null)