package ifp.pmm.ejemplodebugkotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ifp.pmm.ejemplodebugkotlin.ui.theme.EjemploDebugKotlinTheme


class ActividadPrincipal : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val pregunta = getString(R.string.question_string)
        val respuesta = resources.getInteger(R.integer.respuesta)
        val respuestaCorrecta =
            resources.getInteger(R.integer.respuesta_correcta)

        val stringRespuesta =
            if (respuesta == respuestaCorrecta) {
                respuestaCorrecta.toString()
            } else {
                getString(R.string.fan_falso)
            }

        setContent {
            EjemploDebugKotlinTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComponenteInterfazLBJ(pregunta, stringRespuesta)
                }
            }
        }
    }
}


@Composable
fun ComponenteInterfazLBJ(pregunta: String,
                          respuesta: String) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            modifier = Modifier
                .height(50.dp)
                .weight(1f)
        ) {
            Text(pregunta)
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(6f),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = respuesta,
                fontSize = 50.sp,
                fontWeight = FontWeight.ExtraBold,
                textAlign = TextAlign.Center
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ComponenteInterfazLBJPreview() {
    EjemploDebugKotlinTheme {
        ComponenteInterfazLBJ(pregunta = "¿Cómo estás?",
            respuesta = "bien vamos tirando, se hace por vivir"
        )
    }
}