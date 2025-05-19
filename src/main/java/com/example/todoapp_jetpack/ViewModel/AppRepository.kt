package com.example.todoapp_jetpack.ViewModel

import com.example.todoapp_jetpack.Model.ToDo


class AppRepository {
    private val todolist = mutableListOf(
        ToDo(task = "Laptop", date = "May 20. 2025",false),
        ToDo(task = "Laptop", date = "May 20. 2025",false),
    )
    fun getInitialStaticList(): List<ToDo> {
        return todolist
    }
    fun addNewProductStaticly(p: ToDo) {
            todolist.add(p)
    }
}