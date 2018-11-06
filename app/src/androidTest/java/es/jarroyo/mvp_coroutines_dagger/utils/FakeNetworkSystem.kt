package es.jarroyo.mvp_coroutines_dagger.utils

import android.content.Context
import com.microhealth.lmc.utils.NetworkSystemAbstract

open class FakeNetworkSystem(private val appContext : Context): NetworkSystemAbstract() {

    companion object {
        var mIsNetworkAvailable = true

        fun setNetworkAvailable (isNetworkAvailable: Boolean){
            mIsNetworkAvailable = isNetworkAvailable
        }
    }


    override fun isNetworkAvailable(): Boolean {
        return mIsNetworkAvailable
    }
}