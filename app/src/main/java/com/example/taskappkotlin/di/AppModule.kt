package com.example.taskappkotlin.di

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class AppModule(val context: Context) {

    @Provides
    fun provideContext(): Context {
        return context
    }

//    @Provides
//    fun provideMainViewModelFactory(
//        getUseListUseCase: GetShopListUseCase,
//        deleteShopItemUseCase: DeleteShopItemUseCase
//    ): MainViewModelFactory {
//        return MainViewModelFactory(getUseListUseCase, deleteShopItemUseCase)
//    }
//
//    @Provides
//    fun provideAddViewModelFactory(addShopItemUseCase: AddShopItemUseCase): AddViewModelFactory {
//        return AddViewModelFactory(addShopItemUseCase = addShopItemUseCase)
//    }


}