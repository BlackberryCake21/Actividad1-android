package com.ecommerce.miaplicacion

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource

@Composable
fun main(){
    Box(){
        Column(

        ){
            Text("Mi nombre es: Jhonatan")
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "imagen"
            )
            Text("Soy super wow")
        }
        Row {
            footerbar()
        }
    }
}


@Composable
fun footerbar(){
    Row() {
        items()
        items()
        items()
    }
}

@Composable
fun items(){
    Box(){

    }
}