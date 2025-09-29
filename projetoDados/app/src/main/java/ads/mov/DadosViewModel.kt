package ads.mov.comviewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

enum class situacaoJogo {
    INICIO, PONTO, VENCEU, PERDEU
}

data class DadosUiState(
    val dado1: Int = 6,
    val dado2: Int = 6,
    val situacao: situacaoJogo = situacaoJogo.INICIO,
    val ponto: Int = 0
)

class DadosViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(DadosUiState())
    val uiState = _uiState.asStateFlow()

    fun jogarDados() {
        val d1 = (1..6).random()
        val d2 = (1..6).random()
        val soma = d1 + d2

        _uiState.update { estadoAtual ->
                estadoAtual.copy(dado1 = d1, dado2 = d2)
            }


        val novoEstado = when (uiState.value.situacao) {
            situacaoJogo.INICIO -> {
                when (soma) {
                    7, 11 -> DadosUiState(dado1 = d1, dado2 = d2, situacao = situacaoJogo.VENCEU)
                    2, 3, 12 -> DadosUiState(dado1 = d1, dado2 = d2, situacao = situacaoJogo.PERDEU)
                    else -> DadosUiState(
                        dado1 = d1,
                        dado2 = d2,
                        ponto = soma,
                        situacao = situacaoJogo.PONTO
                    )
                }
            }

            situacaoJogo.PONTO -> {
                when (soma) {
                    _uiState.value.ponto -> DadosUiState(dado1 = d1, dado2 = d2, situacao = situacaoJogo.VENCEU)
                    7 -> DadosUiState(dado1 = d1, dado2 = d2, situacao = situacaoJogo.PERDEU)
                    else -> DadosUiState(
                    dado1 = d1,
                    dado2 = d2,
                    ponto = soma,
                    situacao = situacaoJogo.PONTO
                    )
                }
            }

            else -> DadosUiState(
                dado1 = 6,
                dado2 = 6,
                situacao = situacaoJogo.INICIO,
                ponto = 0
            )
        }
        _uiState.value = novoEstado
    }
    

    fun getMensagem(): String {
        return when (_uiState.value.situacao) {
            situacaoJogo.INICIO -> "Clique em jogar dados"
            situacaoJogo.PONTO -> "Ponto a ser buscado: ${_uiState.value.ponto}"
            situacaoJogo.VENCEU -> "Você venceu"
            situacaoJogo.PERDEU -> "Você perdeu"
        }
    }
    fun getMensagem2(): String {
        return when (_uiState.value.situacao) {
            situacaoJogo.INICIO, situacaoJogo.PONTO -> "Jogar dados"
            else -> "Reiniciar jogo"
        }
    }
}

