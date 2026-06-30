package dev.dorosh.paparazzi.repro

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.add
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.dorosh.paparazzi.repro.ui.theme.PaparazziRTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PaparazziRTheme { Greeting() }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    val focusRequester = remember { FocusRequester() }
    var name by remember { mutableStateOf("Name") }
    Scaffold(
        modifier = modifier.fillMaxSize(),
        contentWindowInsets = WindowInsets.safeDrawing
            .add(WindowInsets.ime),
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            Text(text = "Hello $name!")
            Spacer(Modifier.size(16.dp))
            TextField(
                value = name,
                placeholder = {
                    Text("Your name")
                },
                modifier = Modifier.focusRequester(focusRequester),
                onValueChange = { name = it },
            )
        }
    }

}

@Preview(
    group = "E2E - Light",
    device = "spec:parent=pixel_9,navigation=gesture",
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    showSystemUi = true,
)
@Preview(
    group = "E2E - Dark",
    device = "spec:parent=pixel_9,navigation=buttons",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showSystemUi = true,
)
@Composable
fun GreetingPreview() {
    PaparazziRTheme {
        Greeting()
    }
}