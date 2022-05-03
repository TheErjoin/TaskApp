package com.example.domain

import javax.inject.Inject

class EditShopItemUseCase @Inject constructor(private val repository: ShopListRepository) {

    fun editShopItem(shopItem: ShopItem) {
        repository.editShopList(shopItem)
    }

}