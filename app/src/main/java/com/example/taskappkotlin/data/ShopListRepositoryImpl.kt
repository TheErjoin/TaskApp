package com.example.taskappkotlin.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.taskappkotlin.App
import com.example.taskappkotlin.domain.ShopItem
import com.example.taskappkotlin.domain.ShopListRepository

object ShopListRepositoryImpl : ShopListRepository {

    //    private var autoIncrementId = 0
    private val mapper = ShopListMapper()

    override fun addShopItem(shopItem: ShopItem) {
        App.appDatabase.shopListDao().addShopItem(mapper.mapEntityToDBModel(shopItem))
    }

    override fun deleteShopItem(shopItem: ShopItem) {
        App.appDatabase.shopListDao().deleteShopItem(mapper.mapEntityToDBModel(shopItem))
    }

    override fun getShopList(): LiveData<List<ShopItem>> = Transformations.map(
        App.appDatabase.shopListDao().getShopList()
    ) {
        mapper.mapListDbModelToListEntity(it)
    }

    override fun editShopList(shopItem: ShopItem) {
        App.appDatabase.shopListDao().updateShopItem(mapper.mapEntityToDBModel(shopItem))
    }

    override fun getShopItem(shopItemId: Int): ShopItem {
//        return shopList.find {
//            it.id == shopItemId
//        } ?: throw RuntimeException("Element with id $shopItemId not found")
        val dbModel = App.appDatabase.shopListDao().getShopItem(shopItemId)
        return mapper.mapDbModelToEntity(dbModel)
    }
}