package es.jarroyo.mvp_coroutines_dagger.domain.usecase.base

abstract class BaseUseCase<R : BaseRequest, T>() {

    var request: R? = null

    suspend fun execute(request: R? = null): Response<T> {
        this.request = request

        val validated = request?.validate() ?: true
        if(validated) return Response(run())
        return Response(data = null)
    }

    abstract suspend fun run(): T
}

