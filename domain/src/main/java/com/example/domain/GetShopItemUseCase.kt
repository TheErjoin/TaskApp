package com.example.domain

import javax.inject.Inject

class GetShopItemUseCase @Inject constructor( val repository: ShopListRepository) {

    fun getShopItem(shopItemId: Int) = repository.getShopItem(shopItemId)
}