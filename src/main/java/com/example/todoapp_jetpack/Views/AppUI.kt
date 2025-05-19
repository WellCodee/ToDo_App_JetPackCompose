package com.example.todoapp_jetpack.Views

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.todoapp_jetpack.Model.ToDo

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppUIScreen(
    navController: NavController,
    list: SnapshotStateList<ToDo>,
){
    Scaffold (
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(title = {
                Text("Product List")
            })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate("AddNewToDo")
            }) {
                Icon(Icons.Default.Add, contentDescription = "add")
            }
        }
    ) { innerPadding ->
        LazyColumn (
            modifier = Modifier.padding(innerPadding)
        ) {
            items(count = list.toList().count() ){
                    index: Int ->
                Column {
                    Row(
                        modifier = Modifier.fillMaxWidth().
                        border(1.dp, Color.Black).padding(10.dp).
                        background(
                            if (list.toList()[index].isUrgent) Color.Red else Color.Green
                        )

                    ) {
                        Column(modifier = Modifier.fillMaxWidth(0.7f)) {
                            Text(fontSize = 20.sp, text = "Task: " + list.toList()[index].task)
                            Spacer(Modifier.height(10.dp))
                            Text(
                                fontSize = 20.sp,
                                text = "Date: " + list.toList()[index].date
                            )
                        }
                    }
                    Spacer(Modifier.height(10.dp))
                }
            }
        }

    }
}
