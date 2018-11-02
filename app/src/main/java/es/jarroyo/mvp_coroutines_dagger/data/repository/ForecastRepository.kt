package es.jarroyo.mvp_coroutines_dagger.data.repository


import es.jarroyo.mvp_coroutines_dagger.data.source.disk.DiskDataSource
import es.jarroyo.mvp_coroutines_dagger.data.source.network.GithubAPI
import es.jarroyo.mvp_coroutines_dagger.data.source.network.NetworkDataSource

class ForecastRepository(private val networkDataSource: NetworkDataSource,
                         private val diskDataSource: DiskDataSource
) {

    val TAG = ForecastRepository::class.java.simpleName


    /***********************************************************************************************
     * GET DATA FORECAST
     **********************************************************************************************/
    suspend fun getForecastData(): List<GithubAPI.Repo> {
        val result = networkDataSource.getGitHubData()
        return result
    }
}