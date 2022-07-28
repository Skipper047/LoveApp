package com.example.loveapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.loveapp.model.LoveModel

@Database(entities = [LoveModel::class], version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun loveModelDao(): LoveModelDao
}