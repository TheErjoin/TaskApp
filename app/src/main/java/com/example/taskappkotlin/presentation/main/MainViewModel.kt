package com.example.taskappkotlin.presentation.main

import androidx.lifecycle.ViewModel
import com.example.taskappkotlin.data.ShopListRepositoryImpl
import com.example.taskappkotlin.domain.*

class MainViewModel : ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val addShopItemUseCase = AddShopItemUseCase(repository)

    private val getShopItemListUseCase = GetShopListUseCase(repository)

    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)

    private val editShopItemUseCase = EditShopItemUseCase(repository)

    private val getShopItemUseCase = GetShopItemUseCase(repository)

    val shopList = getShopItemListUseCase.getShopList()

    fun addShopItem(shopItem: ShopItem) {
        addShopItemUseCase.addShopItem(shopItem)
    }

    fun editShopItem(shopItem: ShopItem) {
        editShopItemUseCase.editShopItem(shopItem)
    }

//    fun getShopList() {
//        val list = getShopItemListUseCase.getShopList()
//        shopList.value = list
//    }

    fun deleteShop(shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }

//    fun changeEnableState(shopItem: ShopItem) {
//        val newItem = shopItem.copy(enabled = !shopItem.enabled)
//        editShopItemUseCase.editShopItem(newItem)
//    }

    fun getShopItem(shopItemId: Int): ShopItem {
        return getShopItemUseCase.getShopItem(shopItemId)
    }
}