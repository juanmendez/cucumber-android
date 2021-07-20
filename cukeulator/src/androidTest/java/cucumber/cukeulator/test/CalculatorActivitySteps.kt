package cucumber.cukeulator.test

import android.app.Activity
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ActivityScenario.ActivityAction
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import cucumber.cukeulator.CalculatorActivity
import cucumber.cukeulator.R
import io.cucumber.java.After
import io.cucumber.java.Before
import io.cucumber.java.en.Given
import io.cucumber.java.en.When
import org.junit.Assert

/**
 * We use [ActivityScenario] in order to have access to methods like getActivity
 * and getInstrumentation.
 *
 * The CucumberOptions annotation is mandatory for exactly one of the classes in the test project.
 * Only the first annotated class that is found will be used, others are ignored. If no class is
 * annotated, an exception is thrown.
 *
 *
 * The options need to at least specify features = "features". Features must be placed inside
 * assets/features/ of the test project (or a subdirectory thereof).
 */
@Suppress("unused")
class CalculatorActivitySteps(private val dependency: SomeDependency?) {
    /**
     * Since [CucumberJUnitRunner] has the control over the
     * test lifecycle, activity test rules must not be launched automatically. Automatic launching of test rules is only
     * feasible for JUnit tests. Fortunately, we are able to launch the activity in Cucumber's [Before] method.
     */
    private lateinit var scenario: ActivityScenario<CalculatorActivity>
    private var calculatorActivity: CalculatorActivity? = null

    /**
     * We launch the activity in Cucumber's [Before] hook.
     * See the notes above for the reasons why we are doing this.
     */
    @Before
    fun launchActivity() {
        scenario = ActivityScenario.launch(CalculatorActivity::class.java)
        scenario.onActivity(ActivityAction { activity: CalculatorActivity? ->
            calculatorActivity = activity
        })
    }

    /**
     * All the clean up of application's data and state after each scenario must happen here
     */
    @After
    fun finishActivity() {
        scenario.close()
    }

    /**
     * Gets the activity from our test rule.
     *
     * @return the activity
     */
    private val activity: Activity?
        private get() = calculatorActivity

    @Given("I have a CalculatorActivity")
    fun i_have_a_CalculatorActivity() {
        Assert.assertNotNull(activity)
    }

    @When("I press {digit}")
    fun i_press_d(d: Int) {
        when (d) {
            0 -> Espresso.onView(ViewMatchers.withId(R.id.btn_d_0)).perform(ViewActions.click())
            1 -> Espresso.onView(ViewMatchers.withId(R.id.btn_d_1)).perform(ViewActions.click())
            2 -> Espresso.onView(ViewMatchers.withId(R.id.btn_d_2)).perform(ViewActions.click())
            3 -> Espresso.onView(ViewMatchers.withId(R.id.btn_d_3)).perform(ViewActions.click())
            4 -> Espresso.onView(ViewMatchers.withId(R.id.btn_d_4)).perform(ViewActions.click())
            5 -> Espresso.onView(ViewMatchers.withId(R.id.btn_d_5)).perform(ViewActions.click())
            6 -> Espresso.onView(ViewMatchers.withId(R.id.btn_d_6)).perform(ViewActions.click())
            7 -> Espresso.onView(ViewMatchers.withId(R.id.btn_d_7)).perform(ViewActions.click())
            8 -> Espresso.onView(ViewMatchers.withId(R.id.btn_d_8)).perform(ViewActions.click())
            9 -> Espresso.onView(ViewMatchers.withId(R.id.btn_d_9)).perform(ViewActions.click())
        }
    }

    @When("I press {operator}")
    fun i_press_op(op: Char) {
        when (op) {
            '+' -> Espresso.onView(ViewMatchers.withId(R.id.btn_op_add))
                .perform(ViewActions.click())
            '–' -> Espresso.onView(ViewMatchers.withId(R.id.btn_op_subtract))
                .perform(ViewActions.click())
            'x' -> Espresso.onView(ViewMatchers.withId(R.id.btn_op_multiply))
                .perform(ViewActions.click())
            '/' -> Espresso.onView(ViewMatchers.withId(R.id.btn_op_divide))
                .perform(ViewActions.click())
            '=' -> Espresso.onView(ViewMatchers.withId(R.id.btn_op_equals))
                .perform(ViewActions.click())
        }
    }

    init {
        Assert.assertNotNull(dependency)
    }
}