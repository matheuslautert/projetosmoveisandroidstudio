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
import ads.mov.ui.theme.SegundaAplicacaoTheme
import android.provider.MediaStore.Images
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SegundaAplicacaoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
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

fun Imagem(modifier: Modifier = Modifier){
    Surface(
        modifier = modifier
            .windowInsetsPadding(WindowInsets.statusBars)
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.fundo),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 1.0f
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ImagemPreview () {
    Imagem()
}

@Composable
fun Saudacao(nome: String, modifier: Modifier = Modifier) {
    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier=modifier
            .padding(vertical = 4.dp, horizontal = 8.dp)
            .windowInsetsPadding(
                WindowInsets.statusBars
            )
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 8.dp), verticalArrangement = Arrangement.SpaceBetween
        ){
        Text(text = "Olá ")
        Text(text = nome)
    } }
}
@Composable
fun Saudacao2(nome: String, modifier: Modifier = Modifier){
    Column {
        Saudacao(nome, Modifier.weight(1f))
        Saudacao("Outro nome", Modifier.weight(2f))
    }
}
@Composable
fun SaudacaoSemSurface(nome: String, modifier: Modifier = Modifier) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 8.dp), verticalArrangement = Arrangement.SpaceBetween
        ){
            Text(text = "Olá ")
            Text(text = nome)
        } }

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SegundaAplicacaoTheme {
        Greeting("Android")
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun SaudacaoPreview() {
    SegundaAplicacaoTheme {
        Saudacao2("Matheus")
    }
}
@Composable
fun ImageSaudacao() {
    Surface() {
        Box(Modifier){
            Imagem()
            SaudacaoSemSurface("matheus")
        }
    }
}

@Preview
@Composable
private fun ImagemSaudacao() {
    SegundaAplicacaoTheme {
        ImageSaudacao()
    }

}