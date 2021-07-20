package cucumber.cukeulator.test

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.filters.SmallTest
import cucumber.cukeulator.CalculatorActivity
import cucumber.cukeulator.R
import org.junit.Before
import org.junit.Test

/**
 * The aim of this test is to make sure that it is possible to run non cucumber instrumentation tests.
 */
class InstrumentationNonCucumberTest {
    private lateinit var scenario: ActivityScenario<CalculatorActivity>

    @Before
    @Throws(Exception::class)
    fun setUp() {
        scenario = ActivityScenario.launch(CalculatorActivity::class.java)
    }

    @SmallTest
    @Test
    fun assert_that_click_on_0_is_visible_in_the_text_cal_display() {
        Espresso.onView(ViewMatchers.withId(R.id.btn_d_0))
            .perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.txt_calc_display))
            .check(ViewAssertions.matches(ViewMatchers.withText("0")))
    }
}