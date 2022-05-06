package com.example.domain.usecase

import com.example.domain.entity.ShopItem
import com.example.domain.repository.ShopListRepository
import javax.inject.Inject

class EditShopItemUseCase @Inject constructor(private val repository: ShopListRepository) {

    fun editShopItem(shopItem: ShopItem) {
        repository.editShopList(shopItem)
    }

}