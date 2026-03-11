package yuri.garcia.ejerciciomvvm_garciayuri.viewmodel

import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import yuri.garcia.ejerciciomvvm_garciayuri.data.models.Pokemon

class PokemonViewModel : ViewModel(){ //Hereda de ViewModel
    private val pokemonDisponibles = listOf(
        Pokemon("Zeraora", "Eléctrico"),
        Pokemon("Meowscarada", "Siniestro / Planta"),
        Pokemon("Lucario", "Lucha"),
    )

    var pokemonSalvaje by mutableStateOf<Pokemon?>(null)
        private set

    var capturados by mutableStateOf(listOf<Pokemon>())
        private set

    fun buscarEnLaHierva(){
        pokemonSalvaje = pokemonDisponibles.random()
    }

    fun capturar(){
        pokemonSalvaje?.let {
            val succes = (0..100).random()
            if (succes > 50){
                capturados = capturados + it
                pokemonSalvaje = null
            } else {
                pokemonSalvaje = null
            }
        }
    }


}