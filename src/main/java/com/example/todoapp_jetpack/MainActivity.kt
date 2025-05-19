package com.example.todoapp_jetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todoapp_jetpack.Model.ToDo
import com.example.todoapp_jetpack.Navigation.AddNewToDo
import com.example.todoapp_jetpack.Navigation.ListOfTodo
import com.example.todoapp_jetpack.ViewModel.ToDoViewModel
import com.example.todoapp_jetpack.Views.AddNewToDoScreen
import com.example.todoapp_jetpack.Views.AppUIScreen

class MainActivity : ComponentActivity() {
    lateinit var vm : Lazy<ToDoViewModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            vm = viewModels<ToDoViewModel>()// connection between UI and VM
            MyApp(vm)
        }
        }
    }

@Composable
fun MyApp(vm: Lazy<ToDoViewModel>) {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "ListOfToDo") {
        composable("ListOfToDo") { backStackEntry ->
            AppUIScreen(navController,vm.value.stateList)
        }
        composable("AddNewToDo") {
            AddNewToDoScreen(navController) { n,d,i ->
                vm.value.addNewProduct(ToDo(n,d,i))
          } } }
    }

