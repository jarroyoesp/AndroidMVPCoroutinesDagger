package es.jarroyo.mvp_coroutines_dagger.ui.home.activity

import android.support.test.espresso.Espresso
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.runner.AndroidJUnit4
import es.jarroyo.mvp_coroutines_dagger.R
import es.jarroyo.mvp_coroutines_dagger.app.baseTest.BaseActivityRule
import es.jarroyo.mvp_coroutines_dagger.utils.FakeNetworkSystem
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeActivityTest {

    @Rule
    @JvmField
    var mActivityRule = BaseActivityRule(HomeActivity::class.java, true, false)

    /**
     * Test that checks if network is not available show No internet connection error
     */
    @Test
    fun testNoInternetShowError() {
        FakeNetworkSystem.setNetworkAvailable(false)

        mActivityRule.launchActivity()

        Espresso.onView(ViewMatchers.withId(R.id.activity_home_tv_title)).check(matches(isDisplayed()))
        // Comprobamos que se muestra el mensaje de error
        Espresso.onView(ViewMatchers.withId(R.id.activity_home_tv_title)).check((matches(
            ViewMatchers.withText(
                "NetworkConnectionException"
            )
        )))
    }
}