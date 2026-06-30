package dev.dorosh.paparazzi.a

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalTextInputService
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.dorosh.paparazzi.design.theme.PaparazziRTheme

@Composable
fun WelcomeCard(modifier: Modifier = Modifier) {
    Card(modifier = modifier.padding(16.dp)) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = "Welcome", style = MaterialTheme.typography.titleLarge)
            Text(text = "Shared composable", style = MaterialTheme.typography.bodyLarge)
        }
    }
    val textInputService = LocalTextInputService.current
    textInputService!!.showSoftwareKeyboard()
}

@Preview
@Composable
fun WelcomeCardPreview() {
    PaparazziRTheme(dynamicColor = false) {
        WelcomeCard()
    }
}
