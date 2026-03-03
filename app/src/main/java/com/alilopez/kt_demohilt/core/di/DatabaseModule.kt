package com.alilopez.kt_demohilt.core.di

import android.content.Context
import androidx.room.Room
import com.alilopez.kt_demohilt.core.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "JsonPlaceHoldeDB"
        ).build()
    }

    @Provides
    fun providePostDao(db: AppDatabase) = db.postDao()
}