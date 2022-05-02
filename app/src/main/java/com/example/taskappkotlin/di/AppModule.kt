package com.example.taskappkotlin.di

import android.content.Context
import com.example.domain.ShopListRepository
import com.example.taskappkotlin.presentation.fragment.add.viewModel.AddViewModelFactory
import com.example.taskappkotlin.presentation.fragment.main.viewModel.MainViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModule(val context: Context) {

    @Provides
    fun provideContext(): Context {
        return context
    }

    @Provides
    fun provideMainViewModelFactory(repository: ShopListRepository): MainViewModelFactory {
        return MainViewModelFactory(repository = repository)
    }

    @Provides
    fun provideAddViewModelFactory(repository: ShopListRepository): AddViewModelFactory {
        return AddViewModelFactory(repository = repository)
    }

}