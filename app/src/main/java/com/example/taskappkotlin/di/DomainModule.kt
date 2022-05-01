package com.example.taskappkotlin.di

import com.example.domain.*
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideAddShopUseCase(shopListRepository: ShopListRepository): AddShopItemUseCase {
        return AddShopItemUseCase(shopListRepository = shopListRepository)
    }

    @Provides
    fun provideDeleteShopUseCase(shopListRepository: ShopListRepository): DeleteShopItemUseCase {
        return DeleteShopItemUseCase(shopListRepository = shopListRepository)
    }

    @Provides
    fun provideGetShopUseCase(shopListRepository: ShopListRepository): GetShopListUseCase {
        return GetShopListUseCase(shopListRepository = shopListRepository)
    }

    @Provides
    fun provideGetItemShopUseCase(shopListRepository: ShopListRepository): GetShopItemUseCase {
        return GetShopItemUseCase(repository = shopListRepository)
    }
}