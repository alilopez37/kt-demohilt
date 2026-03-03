package com.alilopez.kt_demohilt.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alilopez.kt_demohilt.features.jsonplaceholder.data.datasources.local.dao.PostDao
import com.alilopez.kt_demohilt.features.jsonplaceholder.data.datasources.local.entities.PostEntity

@Database(
    entities = [PostEntity::class,
                //UserEntity::class
                ],
    version = 1, // Versión inicial (clave para migraciones futuras)
    exportSchema = false
)

abstract class AppDatabase : RoomDatabase() {
    abstract fun postDao(): PostDao
    //abstract fun userDao(): UserDao
}