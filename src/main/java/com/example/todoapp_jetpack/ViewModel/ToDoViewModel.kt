package com.example.todoapp_jetpack.ViewModel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import com.example.todoapp_jetpack.Model.ToDo


class ToDoViewModel() : ViewModel() {
    var repo = AppRepository() // source of truth
    var stateList: SnapshotStateList<ToDo> = mutableStateListOf<ToDo>().apply {
        addAll(repo.getInitialStaticList())
    }
    fun addNewProduct(p: ToDo) {
        repo.addNewProductStaticly(p)
        stateList.add(p)
    }
}