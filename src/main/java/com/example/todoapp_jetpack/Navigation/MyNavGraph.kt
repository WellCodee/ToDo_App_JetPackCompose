package com.example.todoapp_jetpack.Navigation

import androidx.compose.foundation.magnifier
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.todoapp_jetpack.MainActivity
import com.example.todoapp_jetpack.Views.AddNewToDoScreen
import kotlinx.serialization.Serializable

open class Item (
    val path:String,
    val title: String,
    val icon: ImageVector
){}

    @Serializable
    object ListOfTodo//: Item("List","List of Tasks", Icons.Default.Build)
    @Serializable
    object AddNewToDo//: Item("AddNewToDo","Add New Task", Icons.Default.Settings)


//@Composable
//fun MyNavGraph(navController: NavHostController){
//    NavHost(navController = navController,
//        startDestination = NavItem.ListOfTodo.path) {
//
//        composable<NavItem.ListOfTodo>{}
//        composable<NavItem.AddNewToDo>{}
//        }
//    }