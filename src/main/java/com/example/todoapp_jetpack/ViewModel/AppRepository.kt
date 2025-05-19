package com.example.todoapp_jetpack.ViewModel

import com.example.todoapp_jetpack.Model.ToDo


class AppRepository {
    private val todolist = mutableListOf<ToDo>()
    fun getInitialStaticList(): List<ToDo> {
        return todolist
    }
    fun addNewProductStaticly(p: ToDo) {
            todolist.add(p)
    }
    fun updateOneTask(index: Int, value: Boolean) {
        todolist[index] = todolist[index].copy(isUrgent = value)    }
    fun deleteOneTask(todo: ToDo) {
        todolist.remove(todo)
    }
}