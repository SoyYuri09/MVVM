package yuri.garcia.ejerciciomvvm_garciayuri.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import yuri.garcia.ejerciciomvvm_garciayuri.viewmodel.PokemonViewModel

@Composable
fun PokeScreeen(
    viewModel: PokemonViewModel = viewModel()
){
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Atrapa el tuyo oyuyo")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            viewModel.buscarEnLaHierva()
        }) {
            Text(text = "Buscar en la hierva")
        }
        Spacer(modifier = Modifier.height(16.dp))
        //Valida automáticamente si es nulo y ya no truena
        viewModel.pokemonSalvaje?.let {
            Text(text = "Alv apareció un ${it.name}!!")
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {viewModel.capturar()}) {
                Text(text = "Capturar")
            }
        }

        LazyColumn() {
            items(viewModel.capturados){ pokemon ->
                Text(text = "${pokemon.name} - tipo: ${pokemon.type}")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PokeScreenPreview(){
    PokeScreeen()
}