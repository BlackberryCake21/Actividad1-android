package com.ecommerce.miaplicacion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ecommerce.miaplicacion.ui.theme.MiAplicacionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MiAplicacionTheme {
                App()
            }
        }
    }
}
//{}


@Preview
@Composable
fun home() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .border(BorderStroke(10.dp,Color.Black))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .border(BorderStroke(10.dp,Color.Black)),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(20.dp)
                    .border(BorderStroke(5.dp,Color.Black))
            ) { }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)

                    .border(BorderStroke(3.dp,Color.Black)),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Column() {
                    Text(text = "1")
                    Text(text = "2")
                }
                Column {
                    Text(text = "3")
                    Text(text = "4")
                }
                Column {
                    Text(text = "5")
                    Text(text = "6")
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(20.dp)
                    .border(BorderStroke(5.dp,Color.Black))
            ) { }
        }
    }
}






