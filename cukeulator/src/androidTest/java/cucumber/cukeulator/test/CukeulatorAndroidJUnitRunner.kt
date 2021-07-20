package cucumber.cukeulator.test

import android.os.Bundle
import io.cucumber.android.runner.CucumberAndroidJUnitRunner
import io.cucumber.junit.CucumberOptions
import java.io.File

/**
 * The CucumberOptions annotation is mandatory for exactly one of the classes in the test project.
 * Only the first annotated class that is found will be used, others are ignored. If no class is
 * annotated, an exception is thrown. This annotation does not have to placed in runner class
 */
@CucumberOptions(features = ["features"], strict = true)
class CukeulatorAndroidJUnitRunner : CucumberAndroidJUnitRunner() {
    companion object {
        const val FILE_NAME = "cucumber"
        const val SEPARATOR = "--"
    }
    override fun onCreate(bundle: Bundle) {
        bundle.putString(
            "plugin",
            pluginConfigurationString
        ) // we programmatically create the plugin configuration
        //it crashes on Android R without it
        File(absoluteFilesPath).mkdirs()
        super.onCreate(bundle)
    }

    /**
     * Since we want to checkout the external storage directory programmatically, we create the plugin configuration
     * here, instead of the [CucumberOptions] annotation.
     *
     * @return the plugin string for the configuration, which contains XML, HTML and JSON paths
     */
    private val pluginConfigurationString: String
        get() {
            return "junit:" + getCucumberXml() + SEPARATOR +
                "html:" + getCucumberHtml()
        }

    private fun getCucumberHtml(): String {
        return "$absoluteFilesPath/$FILE_NAME.html"
    }

    private fun getCucumberXml(): String {
        return "$absoluteFilesPath/$FILE_NAME.xml"
    } //sdcard/Android/data/cucumber.cukeulator

    /**
     * The path which is used for the report files.
     *
     * @return the absolute path for the report files
     */
    private val absoluteFilesPath: String
        get() {

            //sdcard/Android/data/cucumber.cukeulator
            val directory = targetContext.getExternalFilesDir(null)
            return File(directory, "reports").absolutePath
        }
}