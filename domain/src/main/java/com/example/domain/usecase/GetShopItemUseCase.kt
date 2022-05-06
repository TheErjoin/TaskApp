package com.example.domain.usecase

import com.example.domain.repository.ShopListRepository
import javax.inject.Inject

class GetShopItemUseCase @Inject constructor( val repository: ShopListRepository) {

    fun getShopItem(shopItemId: Int) = repository.getShopItem(shopItemId)
}