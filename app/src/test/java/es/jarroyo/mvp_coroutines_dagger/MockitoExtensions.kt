package es.jarroyo.mvp_coroutines_dagger

import org.mockito.Mockito


fun <T> anyContributor(): T {
    return Mockito.anyObject<T>()
}

fun <T> anyRepositorie(): T {
    return Mockito.anyObject<T>()
}