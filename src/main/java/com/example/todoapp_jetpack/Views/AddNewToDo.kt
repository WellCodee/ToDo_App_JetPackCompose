package com.example.todoapp_jetpack.Views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun AddNewToDoScreen(navController: NavController,
               onButtonClicked: (name:String, tdate:String, isurgent: Boolean)->Unit,
) {

    var nameInput = remember { mutableStateOf("") }
    var dateInput = remember { mutableStateOf("") }
    var isUrgentInput = remember { mutableStateOf(false) }

    Column (
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        TextField(
            value = nameInput.value,
            onValueChange = {
                nameInput.value = it
            },
            label = {
                Text("Enter Product Name")
            },
            placeholder = {
                Text("e.g. Hats")
            }
        )
        PickerView({
            dateInput.value = it
        })

       Switch(checked = isUrgentInput.value, onCheckedChange = {
           isUrgentInput.value = it
       })
        Button(onClick = {
            if (!nameInput.value.isEmpty()){

                onButtonClicked(nameInput.value, dateInput.value,isUrgentInput.value)
                navController.popBackStack()
            }
        }) {
            Text("Save New Product")
        }


    }
}