package com.example.domain.repository

import com.example.domain.entity.ShopItem
import kotlinx.coroutines.flow.Flow


interface ShopListRepository {

    fun addShopItem(shopItem: ShopItem)

    fun deleteShopItem(shopItem: ShopItem)

    fun getShopList(): Flow<List<ShopItem>>

    fun editShopList(shopItem: ShopItem)

    fun getShopItem(shopItemId: Int): ShopItem

}