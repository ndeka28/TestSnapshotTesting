package com.nila.testshot

import android.view.View
import android.widget.EditText
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.MutableLiveData
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers
import com.karumi.shot.FragmentScenarioUtils.waitForFragment
import com.karumi.shot.ScreenshotTest
import com.nila.testshot.util.ViewModelUtil
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock


class LoginFragmentTest : ScreenshotTest {

    private lateinit var viewModel: LoginViewModel

    private val loginVisibilty = MutableLiveData<Boolean>()

    @Before
    fun init() {
        viewModel = mock(LoginViewModel::class.java)
        loginVisibilty.postValue(null)
        `when`(viewModel.loginState).thenReturn(loginVisibilty)
    }

    @Test
    fun launchLoginFragment() {
        val fragment = launchFragmentInContainer {
            TestLoginFragment().apply {
                viewModelFactory = ViewModelUtil.createFor(viewModel)
            }
        }.waitForFragment()

        compareScreenshot(fragment)
    }

    @Test
    fun typeEdittext() {
        val fragment = launchFragmentInContainer {
            TestLoginFragment().apply {
                viewModelFactory = ViewModelUtil.createFor(viewModel)
            }
        }.waitForFragment()

        Espresso.onView(ViewMatchers.withId(R.id.editTextTextPersonName))
            .perform(ViewActions.clearText(), ViewActions.typeText("Hello Nila"))

        val editView = fragment.requireView().findViewById<EditText>(R.id.editTextTextPersonName)

        compareScreenshot(editView)
    }

    @Test
    fun loginSuccessTest() {
        `when`(viewModel.loginState).thenReturn(loginVisibilty)
        `when`(viewModel.login()).then {
            loginVisibilty.postValue(true)
        }
        val fragment = launchFragmentInContainer {
            TestLoginFragment().apply {
                viewModelFactory = ViewModelUtil.createFor(viewModel)
            }
        }.waitForFragment()

        Espresso.onView(ViewMatchers.withId(R.id.btn_login)).perform(click())

        compareScreenshot(fragment)
    }

    @Test
    fun loginFailedTest() {
        `when`(viewModel.loginState).thenReturn(loginVisibilty)
        `when`(viewModel.login()).then {
            loginVisibilty.postValue(false)
        }

        val fragment = launchFragmentInContainer {
            TestLoginFragment().apply {
                viewModelFactory = ViewModelUtil.createFor(viewModel)
            }
        }.waitForFragment()

        Espresso.onView(ViewMatchers.withId(R.id.btn_login)).perform(click())

        compareScreenshot(fragment)
    }

    override fun disableFlakyComponentsAndWaitForIdle(view: View?) {
        Thread.sleep(300)
        super.disableFlakyComponentsAndWaitForIdle(view)
    }
}


class TestLoginFragment : LoginFragment() {

    override fun injectMembers() {
    }
}
