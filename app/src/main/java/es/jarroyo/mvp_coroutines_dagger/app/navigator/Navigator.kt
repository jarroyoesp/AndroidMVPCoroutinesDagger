package es.jarroyo.mvp_coroutines_dagger.app.navigator

import android.content.Intent
import android.os.Bundle
import es.jarroyo.mvp_coroutines_dagger.ui.base.BaseActivity

class Navigator {

    var currentActivity: BaseActivity? = null

    private fun toDefaultActivity(activity: Class<*>, bundle: Bundle? = null) {
        val intent = Intent(currentActivity, activity)
        if (bundle != null) {
            intent.putExtras(bundle)
        }
        currentActivity?.startActivity(intent)
    }

    private fun toDefaultActivityForResult(requestCode: Int, activity: Class<*>, bundle: Bundle? = null) {
        val intent = Intent(currentActivity, activity)
        if (bundle != null) {
            intent.putExtras(bundle)
        }
        currentActivity?.startActivityForResult(intent, requestCode)
    }

    private fun toDefaultActivityCleaningStack(activity: Class<*>, bundle: Bundle? = null) {
        val intent = Intent(currentActivity, activity)

        if (bundle != null) {
            intent.putExtras(bundle)
        }

        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        currentActivity?.startActivity(intent)
    }

    /***********************************************************************************************
     *  ACTIVITIES
     **********************************************************************************************/

     /***********************************************************************************************
     *  FRAGMENTS
     **********************************************************************************************/

    /**
     * ADD HOME FRAGMENT
     */
    fun addHomeFragment(contentIdLayout: Int) {
        /*var homeFragment = HomeFragment()
        val ft = currentActivity?.supportFragmentManager?.beginTransaction()
        ft?.addToBackStack(HomeFragment::class.java.simpleName)
        ft?.replace(contentIdLayout, homeFragment)?.commit()*/
    }
}
