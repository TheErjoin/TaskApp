package com.example.taskappkotlin.data

import com.example.taskappkotlin.data.room.ShopItemDBModel
import com.example.taskappkotlin.domain.ShopItem

class ShopListMapper {

    fun mapEntityToDBModel(shopItem: ShopItem) = ShopItemDBModel(
        id = shopItem.id,
        name = shopItem.name,
        count = shopItem.count,
        enabled = shopItem.enabled
    )

    fun mapDbModelToEntity(shopItemDb: ShopItemDBModel) = ShopItem(
        id = shopItemDb.id,
        name = shopItemDb.name,
        count = shopItemDb.count,
        enabled = shopItemDb.enabled
    )

    fun mapListDbModelToListEntity(list: List<ShopItemDBModel>) = list.map {
        mapDbModelToEntity(it)
    }



}