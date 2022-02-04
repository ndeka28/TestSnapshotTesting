package com.nila.testshot

import android.app.Application
import android.content.Context
import com.karumi.shot.ShotTestRunner

class CustomTestRunner : ShotTestRunner() {
    override fun newApplication(cl: ClassLoader?, className: String?, context: Context?): Application {
        return super.newApplication(cl, TestApplication::class.java.name, context)
    }
}