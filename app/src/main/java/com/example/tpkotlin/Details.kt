package com.example.tpkotlin

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun Details(NavCtrl: NavController, Id:Int?){

    Scaffold(

        topBar = {
        Card(

        ) {
            Image(painter =     painterResource(id =FakeDogDatabase.dogList[Id!!].image), contentDescription ="Image", modifier = Modifier.fillMaxWidth().padding(30.dp),contentScale = ContentScale.Crop )
            Row(  modifier = Modifier.padding(top = 50.dp)) {
            }
            Icon(Icons.Filled.ArrowBack, contentDescription = "Arrow", tint = Color.White, modifier = Modifier.clickable { NavCtrl.navigate("List") }.size(30.dp))
            Icon(Icons.Filled.Favorite, contentDescription = "Arrow")
        }

        }
            ) {

        }

}