package ads.mov

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ads.mov.ui.theme.AulaEstadoTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AulaEstadoTheme {
                HidratacaoComEstado()

            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun Hidratacao(modifier: Modifier = Modifier){
    Surface(
        modifier = modifier
            .padding(16.dp)
            .windowInsetsPadding(WindowInsets.statusBars)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            var contador by remember { mutableIntStateOf(0) }
            Text(
                modifier = Modifier.padding(vertical =16.dp),
                text = "Você bebeu $contador copos de água",
                style = MaterialTheme.typography.headlineSmall
            )
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = { contador++ },
                enabled = contador < 10
            ) {
                Text(
                    text = "Beber àgua",
                    style = MaterialTheme.typography.headlineSmall
                )
            }
        }

    }
}

@Composable
fun HidratacaoSemEstado(
    contador: Int,
    onValueChange: () -> Unit, // Callback para beber água
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(16.dp)) {
        Text("Você bebeu $contador copos hoje!")
        Button(
            onClick = { onValueChange() }, enabled = contador < 10
        ) {
            Text("Beber")
        }
    }
}
@Composable
fun HidratacaoComEstado(modifier: Modifier = Modifier) {
    var contadorAgua by rememberSaveable { mutableIntStateOf(0) }
    var contadorSuco by rememberSaveable { mutableIntStateOf(0) }
    Column(modifier= modifier.fillMaxSize()) {
        HidratacaoSemEstado(contador = contadorAgua, onValueChange = { contadorAgua++ })
        HidratacaoSemEstado(contador = contadorSuco, onValueChange = { contadorSuco++ })
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun HidratacaoComEstadoPreview() {
    HidratacaoComEstado()

}


@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun HidratacaoPreview() {
    Hidratacao()
    
}










@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AulaEstadoTheme {
        Greeting("Android")
    }
}