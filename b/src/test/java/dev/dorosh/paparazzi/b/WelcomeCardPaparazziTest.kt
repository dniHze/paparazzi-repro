package dev.dorosh.paparazzi.b

import app.cash.paparazzi.Paparazzi
import org.junit.Rule
import org.junit.Test

class WelcomeCardPaparazziTest {

    @get:Rule
    val paparazzi = Paparazzi()

    @Test
    fun welcomeCard() {
        paparazzi.snapshot { WelcomeCardPreview() }
    }
}
