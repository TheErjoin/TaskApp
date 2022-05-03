package com.example.domain

import javax.inject.Inject

class DeleteShopItemUseCase @Inject constructor(val shopListRepository: ShopListRepository) {

    fun deleteShopItem(shopItem: ShopItem) {
        shopListRepository.deleteShopItem(shopItem)
    }

}