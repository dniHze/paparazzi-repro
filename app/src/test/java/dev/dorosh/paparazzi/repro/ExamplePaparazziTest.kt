package dev.dorosh.paparazzi.repro

import app.cash.paparazzi.Paparazzi
import com.android.ide.common.rendering.api.SessionParams
import com.google.testing.junit.testparameterinjector.TestParameter
import com.google.testing.junit.testparameterinjector.TestParameterInjector
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(TestParameterInjector::class)
class ExamplePaparazziTest {

    @get:Rule
    val paparazzi = Paparazzi(
        renderingMode = SessionParams.RenderingMode.NORMAL,
        showSystemUi = true,
        theme = "Theme.PaparazziR",
    )

    @Test
    fun snapshot(
        @TestParameter("1", "2", "3", "4", "5", "6", "7", "8", "9", "10") number: Int,
    ) {
        paparazzi.snapshot(name = "n$number") { GreetingPreview() }
    }
}