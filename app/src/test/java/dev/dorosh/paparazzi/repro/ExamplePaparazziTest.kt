package dev.dorosh.paparazzi.repro

import app.cash.paparazzi.Paparazzi
import com.android.ide.common.rendering.api.SessionParams
import org.junit.Test

import org.junit.Rule


class ExamplePaparazziTest {

    @get:Rule
    val paparazzi = Paparazzi(
        renderingMode = SessionParams.RenderingMode.NORMAL,
        showSystemUi = true,
        theme = "Theme.PaparazziR",
    )

    @Test
    fun snapshot() {
        paparazzi.snapshot { GreetingPreview() }
    }
}