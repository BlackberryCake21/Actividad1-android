package com.ecommerce.miaplicacion

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.text.contextmenu.modifier.appendTextContextMenuComponents
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument


sealed class Screen(val route: String){
    data object Home: Screen(route = "home")
    data object Details: Screen(route = "details/{id}"){
        fun createRoute(id: Int) = "details/$id"
        const val arg = "id"
    }
    data object Settings: Screen(route = "settings")
}

@Composable
fun App(){
    val nav = rememberNavController()
    AppNavGraph(nav)

}

@Composable
fun AppNavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route

    ){
        composable(route = Screen.Home.route){
            HomeScreen(
                onNavigateToDetails = { id ->
                    navController.navigate(route = Screen.Details.createRoute(id))
                },
                onNavigateToSettings = {
                    navController.navigate(route = Screen.Settings.route)
                }
            )
        }
        composable(route = Screen.Details.route,
            arguments = listOf(navArgument(name = Screen.Details.arg){
                type = NavType.IntType
            })
            ){
            stackEntry ->
            val id = stackEntry.arguments?.getInt(Screen.Details.arg)?:-1
            Details(
                id = id,
                onBack = {
                    navController.popBackStack()
                }
            )
        }
        composable(route = Screen.Settings.route){
            Settings(
                onBack = {
                    navController.popBackStack()
                }
            )

        }
    }
}

@Composable
fun HomeScreen(
    onNavigateToDetails: (Int) -> Unit,
    onNavigateToSettings: () -> Unit
) {
    Scaffold(
        modifier = Modifier,
        topBar = {
            Text(text = "Home")
        }
    ){ pading ->
        Column(
            modifier = Modifier
                .padding(paddingValues = pading)
                .fillMaxSize()
        ) {
            Text(
                modifier = Modifier
                    .padding(16.dp),
                text = "Pantalla Home De Navigation Compose"
            )
            LazyRow(

            ) {
                item {
                    Row(
                        modifier = Modifier

                    ) {
                        listOf(1,2,3,4,5,6,7).forEach { id ->
                            AssistChip(
                                modifier = Modifier
                                    .padding(8.dp),
                                onClick = {
                                    onNavigateToDetails(id)
                                },
                                label = {
                                    Text(
                                        text = "Details $id"
                                    )
                                }
                            )
                        }
                    }
                }
            }
            Button(
                onClick = {onNavigateToSettings()}
            ) {
                Text(text = "Settings")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Details(id: Int, onBack: () -> Unit) {
    Scaffold(
        modifier = Modifier,
        topBar = {
            TopAppBar(
                title = {Text(text = "Details") },
                navigationIcon = {
                    Text(
                        modifier = Modifier.clickable {
                            onBack()
                        },
                        text = "←"
                    )
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(paddingValues = padding)
                .fillMaxSize()
        ) {
            Text(
                modifier = Modifier
                    .padding(16.dp),
                text = "Detalles del client con el ID: $id"
            )
            Button(
                onClick = { onBack() }
            ) {
                Text(
                    text = "Vover"
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Settings(onBack: () -> Unit) {
    Scaffold(
        modifier = Modifier,
        topBar = {
            TopAppBar(
                title = {Text(text = "Details") },
                navigationIcon = {
                    Text(
                        modifier = Modifier.clickable {
                            onBack()
                        },
                        text = "←"
                    )
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(paddingValues = padding)
                .fillMaxSize()
        ) {
            Text(
                modifier = Modifier
                    .padding(16.dp),
                text = "Ajustes de la aplicacion"
            )
            Spacer(modifier = Modifier.height(12.dp))
            Button(
                onClick = { onBack() }
            ) {
                Text(
                    text = "Vover"
                )
            }
        }
    }
}
