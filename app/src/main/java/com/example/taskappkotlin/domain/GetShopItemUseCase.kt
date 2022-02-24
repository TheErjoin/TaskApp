package com.example.taskappkotlin.domain

class GetShopItemUseCase(private val repository: ShopListRepository) {

    fun getShopItem(shopItemId: Int) = repository.getShopItem(shopItemId)
}