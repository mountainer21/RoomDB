package com.example.roomdb

import androidx.room.*

@Dao
interface ClientDao {
    @Query("SELECT * FROM student_table")
    fun getAll(): List<Client>

   /* @Query("SELECT * FROM student_table WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<Student>*/

    @Query("SELECT * FROM student_table WHERE roll_no LIKE :roll LIMIT 1")
    suspend fun findByRoll(roll: Int): Client

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(student: Client)

    @Delete
    suspend fun delete(student: Client)

    @Query("DELETE FROM student_table")
    suspend fun deleteAll()
}