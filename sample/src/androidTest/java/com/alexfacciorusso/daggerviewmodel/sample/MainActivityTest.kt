package com.alexfacciorusso.daggerviewmodel.sample

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class MainActivityTest {
    @get:Rule
    var mainActivityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun viewModelInjected() {
        onView(withId(R.id.textView))
                .check(matches(withText("Hello!")))
    }
}