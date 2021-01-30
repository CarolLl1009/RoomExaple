package com.example.roomexaple.model

import androidx.lifecycle.LiveData

class TaskRepository(private val taskDao: TaskDao) {

    //este value va a contener toda la info de la base de datos
    val listAllTask : LiveData<List<TaskEntity>> = taskDao.getAllTask()

    suspend fun insertTask(task: TaskEntity){
        taskDao.insertTask(task)
    }

    suspend fun deleteTask(task: TaskEntity){
        taskDao.deleteTask(task)
    }


}