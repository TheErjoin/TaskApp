package com.example.domain

class EditShopItemUseCase(private val repository: ShopListRepository) {

    fun editShopItem(shopItem: ShopItem) {
        repository.editShopList(shopItem)
    }

}