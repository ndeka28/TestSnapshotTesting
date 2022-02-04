package com.nila.testshot

import android.view.View
import androidx.test.core.app.ActivityScenario
import com.karumi.shot.ActivityScenarioUtils.waitForActivity
import com.karumi.shot.ScreenshotTest
import org.junit.Test


class MainActivityTest : ScreenshotTest {
    @Test
    fun openActivityTest() {

        val activity1 = ActivityScenario.launch(MainActivity::class.java).waitForActivity()

        compareScreenshot(activity = activity1)
    }

    override fun disableFlakyComponentsAndWaitForIdle(view: View?) {
        Thread.sleep(300)
        super.disableFlakyComponentsAndWaitForIdle(view)
    }
}