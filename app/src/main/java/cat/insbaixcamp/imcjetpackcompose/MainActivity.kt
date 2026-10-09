package cat.insbaixcamp.imcjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import cat.insbaixcamp.imcjetpackcompose.ui.theme.IMCJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IMCJetpackComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BMIScreen()
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
fun BMIScreen(){
    var nom: String by remember { mutableStateOf("")}
    var pes : Int by remember { mutableStateOf(80) }
    var alcada : Int by remember {mutableStateOf(180)}
    var bmi: Double by remember { mutableStateOf(0.0) }

    Column(){
        ->
        Text(text = "calculadora de IMC")

    TextField(
        value = "" ,
        onValueChange = {nom = it} ,
        label = { Text(text = "nom")})

        Row(){
            var pes : Int = 80
            Text(text = "pes: $pes kg")
            Button(onClick = { pes--}) {
                Text(text = "-")
            }
            Button(onClick = {pes++}) {
                Text(text = "-")
            }

        }
        Text(text= "Alçada : $alcada cm")
        Slider(
            value = pes.Float() ,
            onValueChange = {pes = it.toInt()},
            valueRange = 100f..200f
        )
        Button(onClick = {
            var alçadaMetres = alcada / 100f
            bmi = (pes /(alcada * alcada)).toDouble()
        }) {
            Text(text= "calcular IMC")
        }
       if (bmi != 0.0){
           Text(text = "IMB: $bmi")
       }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    IMCJetpackComposeTheme {
       BMIScreen()

    }
}