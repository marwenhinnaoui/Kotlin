package com.example.tpkotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.tpkotlin.ui.theme.TpKotlinTheme
data class Owner(val name: String, val bio: String, val image:Int)

class Dog(
    val id: Int,
    val name: String,
    val age: Double,
    val gender: String,
    val color: String,
    val weight: Double,
    val location: String,
    val image: Int,
    val about: String,
    val owner:Owner
)


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TpKotlinTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),

                ) {
                    Navigation()

                }
            }
        }
    }
}
@Composable
fun Navigation(){
    val NavCtlr = rememberNavController()
    NavHost(navController = NavCtlr, startDestination = "List"){
    composable("Details/{Id}"
    ,
        arguments = listOf(navArgument("Id") { type = NavType.IntType })
        )
        {
                backStackEntry ->
                    Details(NavCtlr, backStackEntry.arguments?.getInt("Id")) }
    composable("List") {     DogList(FakeDogDatabase.dogList, NavCtlr) }
    }


}
@Composable
fun DogCard(dog:Dog,  NavCtlr:NavController){

    Surface(
        elevation = 13.dp,
        modifier = Modifier.clickable {
            NavCtlr.navigate("Details/${dog.id}")
        }
    ) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .border(width = 10.dp, shape = RoundedCornerShape(30.dp), color = Color.White)
            .background(Color.White),
                verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            painter = painterResource(id = dog.image,),
            contentDescription = "Profile image",
            modifier = Modifier
                .size(150.dp)
                .clip(shape = CircleShape)
                .border(
                    width = 20.dp,
                    color = Color.White,
                    shape = RoundedCornerShape(35.dp)
                )
        )
        Column(
            verticalArrangement = Arrangement.Center,
        ) {

            Text(text = dog.name )
            Text(text = "${dog.age}")
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(text = dog.location)
                Text(text = dog.name)

            }



        }
    }
    }

}


@Composable
fun DogList(dogs: List<Dog>, NavCtlr: NavController) {
    Scaffold(
        topBar = {
            TopAppBar() {
                
            }
        }
    ){

    LazyColumn(
    ) {
        items(dogs) { dog ->
            DogCard(dog, NavCtlr)
        }
    }
    }

}

