package com.example.taskappkotlin.di

import android.content.Context
import androidx.room.Room
import com.example.data.ShopListRepositoryImpl
import com.example.data.room.AppDatabase
import com.example.data.room.ShopDao
import com.example.domain.ShopListRepository
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideShopListRepository(dao: ShopDao): ShopListRepository {
        return ShopListRepositoryImpl(dao)
    }

    @Provides
    fun provideRoom(context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "taskapp.db")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideShopDao(appDatabase: AppDatabase): ShopDao {
        return appDatabase.shopListDao()
    }

}