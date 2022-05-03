package com.example.domain

import javax.inject.Inject

class AddShopItemUseCase @Inject constructor(val shopListRepository: ShopListRepository) {

    fun addShopItem(shopItem: ShopItem) {
        shopListRepository.addShopItem(shopItem)
    }
}