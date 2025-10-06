package ads.mov

import ads.mov.DataSource.disciplinas
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
import ads.mov.ui.theme.AulaListasTheme
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardDefaults.cardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AulaListasTheme {
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
fun CartaoDisciplina(disciplina: Disciplina, modifier: Modifier = Modifier) {
    Card(
        modifier = Modifier.animateContentSize().padding(8.dp),
        elevation = cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFE3F2FD))
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.Top
        ){
            var isExpanded by remember { mutableStateOf(false) }
            Text(disciplina.sigla )
                Column(
                    modifier = Modifier.clickable { isExpanded = !isExpanded }
                ) {
                    Text(disciplina.nome)
                        Text("Carga horária: ${disciplina.cargaHoraria}")
                            Text(
                                text = "Ementa: ${disciplina.ementa}",
                                style = MaterialTheme.typography.bodySmall,
                                maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                                modifier = Modifier.padding(top = 4.dp)
                            )
                }
        }
    }
}

data class Disciplina(val sigla: String, val nome: String, val cargaHoraria: Int, val ementa: String)
object DataSource {
    val disciplinas = listOf(
        Disciplina("SEG", "Segurança", 80, ementa = "Iniciaasdjsdajhdsahjsdahjsadhjdsahjdsahjsadl dhusausadhhusdahdsahudhsauhudashdsahasdudhasdhuasdhu dsahudashuasdhuasdhuasdhudashusdauuuuuhudsahuasdhuasdhuasdhuasdhuasdhuasd. outras informações"),
        Disciplina("MOV", "Programação dispositivos moveis", 80, ementa = "EmenInicial dsahudashuasdhuasdhuasdhudashusdauuuuuhudsahuasdhuasdhuasdhuasdhuasdhuasd. outras informaçõeta MOV"),
        Disciplina("SOP", "Sistemas Operacionais", 80, ementa = "EmenInicial dsahudashuasdhuasdhuasdhudashusdauuuuuhudsahuasdhuasdhuasdhuasdhuasdhuasd. outras informaçõeta SOP"),
        Disciplina("AEI", "Extensão", 80, ementa = "Ementa EXTENSAO"),
        Disciplina("ING", "INGLES", 80, ementa = "Ementa INGLES"),
        Disciplina("BD", "BANCO DE DADOS", 80, ementa = "Ementa BD"),
        Disciplina("TES", "TOPICOS ESPECIAIS", 80, ementa = "Ementa TES"),
        Disciplina("POO", "PROGRAMAÇÃO ORIENTADA A OBJETOS", 80, ementa = "Ementa POO"),
        Disciplina("LOG", "LÓGICA MATEMÁTICA", 80, ementa = "Ementa LOG"),
        Disciplina("EDF", "EDUCACAO FISICA", 80, ementa = "Ementa EDF"),
        Disciplina("ALG", "ALOGIRTMO", 80, ementa = "Ementa ALG"),
        )
}
@Composable
fun ListaDisciplinas(disciplinas: List<Disciplina>) {
    LazyColumn() {
        items(disciplinas) {
            disciplina ->
            CartaoDisciplina(
                disciplina = disciplina
            )
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

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun ListaDisciplinasPreview(modifier: Modifier = Modifier) {
    Surface(modifier = modifier.windowInsetsPadding(WindowInsets.statusBars)) {
        ListaDisciplinas(disciplinas)
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AulaListasTheme {
        Greeting("Android")
    }
}