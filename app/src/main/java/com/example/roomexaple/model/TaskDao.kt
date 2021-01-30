package com.example.roomexaple.model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TaskDao {
    //inserta una tarea
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: TaskEntity)

    //inserta listado de tareas
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllTask(listTask:List<TaskEntity>)

    //actializar una tarea
    @Update
    suspend fun updateTask(task: TaskEntity)

    //borrar una tarea
    @Delete
    suspend fun deleteTask(task: TaskEntity)

    //borrar elementos de la tabla
    @Query("DELETE FROM task_table")
    suspend fun deleteAll()

    //traer todos lo elementos de la tabla
    @Query("SELECT * FROM task_table")
    fun getAllTask() : LiveData<List<TaskEntity>>
    //trae una tarea buscada por titulo y limita a 1  respuesta
    @Query("SELECT * FROM task_table WHERE title=:title LIMIT 1")
    fun getTaskByTitle(title: String): LiveData<TaskEntity>
    //trae una tarea buscada por id
    @Query("SELECT * FROM task_table WHERE id =:id")
    fun getTaskById(id: Int): LiveData<TaskEntity>

}