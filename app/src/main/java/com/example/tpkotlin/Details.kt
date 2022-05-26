package com.example.tpkotlin

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController

@Composable
fun Details(NavCtrl: NavController, Id:Int?){

    Scaffold(
        topBar = {
        Card() {
            Image(painter =     painterResource(id =FakeDogDatabase.dogList[Id!!].image), contentDescription ="Image", modifier = Modifier.fillMaxWidth(),contentScale = ContentScale.Crop )
            Row() {

            }
        }

        }
            ) {

        }

}