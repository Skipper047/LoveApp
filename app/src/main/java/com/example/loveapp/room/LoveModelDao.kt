package com.example.loveapp.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.loveapp.model.LoveModel

@Dao
interface LoveModelDao {

    @Query("SELECT * FROM loveModel")
    fun getAll(): List<LoveModel>

    @Insert
    fun insert(loveModel: LoveModel)

    @Delete
    fun delete(loveModel: LoveModel)
}