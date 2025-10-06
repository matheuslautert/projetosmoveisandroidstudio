package ads.mov

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults.cardElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

data class Curso(val nome: String, val idImage: Int)
object DataSourceCursos {
    val cursos = listOf(
        Curso("Banco de dados", R.drawable.banco_de_dados),
        Curso("Programação para dispositivos móveis", R.drawable.mov),
        Curso("Sistemas Operacionais", R.drawable.sop),
        Curso("Frontend I", R.drawable.frontend),
        Curso("Comunicação e Expressão", R.drawable.comunicacao),
        Curso("Algoritmos", R.drawable.logica),
        Curso("Inglês Instrumental", R.drawable.ingles),
        Curso("Segurança da Informação", R.drawable.seguranca),
        Curso("Banco de dados", R.drawable.banco_de_dados),
        Curso("Programação para dispositivos móveis", R.drawable.mov),
        Curso("Sistemas Operacionais", R.drawable.sop),
        Curso("Frontend I", R.drawable.frontend),
        Curso("Comunicação e Expressão", R.drawable.comunicacao),
        Curso("Algoritmos", R.drawable.logica),
        Curso("Inglês Instrumental", R.drawable.ingles),
        Curso("Segurança da Informação", R.drawable.seguranca),
        Curso("Banco de dados", R.drawable.banco_de_dados),
        Curso("Programação para dispositivos móveis", R.drawable.mov),
        Curso("Sistemas Operacionais", R.drawable.sop),
        Curso("Frontend I", R.drawable.frontend),
        Curso("Comunicação e Expressão", R.drawable.comunicacao),
        Curso("Algoritmos", R.drawable.logica),
        Curso("Inglês Instrumental", R.drawable.ingles),
        Curso("Segurança da Informação", R.drawable.seguranca),
    )
}

@Composable
fun CartaoCurso(curso: Curso, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.padding(vertical = 4.dp).animateContentSize(),
        elevation = cardElevation(defaultElevation = 4.dp),
    ) {
        Box(
            modifier = modifier.fillMaxWidth()
        ) {
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(curso.idImage),
                contentDescription = curso.nome,
                contentScale = ContentScale.Fit,
                alpha = .5f
            )
            Text(
                modifier = Modifier.align(Alignment.BottomEnd).padding(4.dp),
                text = curso.nome,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun GradeDeCursos(listaDeCursos: List<Curso>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Fixed(count = 2),
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    )
    {
        items(listaDeCursos) { curso ->
            CartaoCurso(curso, modifier = Modifier.padding(8.dp))
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun GradePreview() {
    GradeDeCursos(listaDeCursos = DataSourceCursos.cursos, modifier = Modifier.padding(8.dp))
    }
