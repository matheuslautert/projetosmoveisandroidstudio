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
import ads.mov.ui.theme.DadosTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DadosTheme {
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
fun Dados(modifier: Modifier = Modifier) {
    var face by rememberSaveable { mutableStateOf(0) }
    var face2 by rememberSaveable { mutableStateOf(0) }
    var pontoaBuscar by rememberSaveable { mutableStateOf(0) }
    var soma by rememberSaveable { mutableStateOf(0) }
    var mensagem by rememberSaveable { mutableStateOf("Jogue o dado") }

    val imagem1 = when (face) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
    val imagem2 = when (face2) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

    soma = face + face2
    if (pontoaBuscar == 0 && face != 0) {
        pontoaBuscar = face + face2
    }
    if(soma == 0 ) {
        mensagem = "Jogue o dado"
    }
    if (soma == 7 || soma == 11) {
         mensagem = "Você ganhou"
    }
    else if (soma == 2 || soma == 3 || soma == 12){
         mensagem = "Você perdeu"
    } else if (pontoaBuscar == soma) {
         mensagem = "$face + $face2 = $soma \n Jogador ganhou"
    }else {
         mensagem = "Ponto a ser buscado: $pontoaBuscar \n Jogue novamente"
    }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(imagem1),
            contentDescription = face.toString()
        )

        Image(
            painter = painterResource(imagem2),
            contentDescription = face.toString()
        )
        Text(text = mensagem )

        Button(onClick = {
            face = (1..6).random();
            face2 = (1..6).random()
        }) {
            Text("Jogar", fontSize = 24.sp)
        }

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DadosTheme {
        Greeting("Android")
    }
}

@Preview(showBackground = true)
@Composable
private fun DadosPreview() {
    DadosTheme {
        Dados()
    }
}