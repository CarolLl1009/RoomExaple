package com.example.roomexaple.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.roomexaple.model.TaskDataBase
import com.example.roomexaple.model.TaskEntity
import com.example.roomexaple.model.TaskRepository
import kotlinx.coroutines.launch

class TaskViewModel(application: Application): AndroidViewModel(application) {
    //variable que representa al repositoria
    private val repository: TaskRepository

    //LiveDta que expone la info de modelo
    val allTask: LiveData<List<TaskEntity>>
    init {
        val taskDao = TaskDataBase.getDataBase(application).getTaskDao()
        repository = TaskRepository(taskDao)
        allTask = repository.listAllTask

    }

    fun insertTask(task: TaskEntity) = viewModelScope.launch{
        repository.insertTask(task)
    }

}