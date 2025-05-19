package com.example.todoapp_jetpack.Views

import android.widget.ImageButton
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.magnifier
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.todoapp_jetpack.Model.ToDo

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppUIScreen(
    navController: NavController,
    list: SnapshotStateList<ToDo>,
    onSwitch: (id: Int,value:Boolean)->Unit,
    onDelete: (todo:ToDo)->Unit
){
    var context = LocalContext.current
    var currentIndex = remember { mutableStateOf(0) }
    Scaffold (
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(title = {
                Text("ToDo List")
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
                Column (modifier = Modifier.background(
                    if (list.toList()[index].isUrgent) Color.Red else Color.Green
                )) {
                    Row(
                        modifier = Modifier.fillMaxWidth().
                        border(1.dp,Color.Black
                        ).padding(10.dp).clickable {
                            currentIndex.value = index
                        }
                    ) {
                        Column(modifier = Modifier.fillMaxWidth(0.7f)) {
                            Text(fontSize = 20.sp, text = "Task: " + list.toList()[index].task)
                            Spacer(Modifier.height(10.dp))
                            Text(
                                fontSize = 20.sp,
                                text = "Date: " + list.toList()[index].date
                            )
                        }
                        Switch(
                            checked = list.toList()[index].isUrgent,
                            onCheckedChange = {
                            onSwitch(index,it)
                        })
                        IconButton(onClick = {
                            onDelete(list.toList()[index])
                        }) {
                            Icon(
                                imageVector = Icons.Default.Delete,
                                contentDescription = "Delete",
                                tint = Color.Black // Optional: change color if you want
                            )
                        }
                    }
                    Spacer(Modifier.height(10.dp))
                }
            }
        }
    }
}
