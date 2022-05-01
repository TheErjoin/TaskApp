package com.example.data

import com.example.data.room.ShopDao
import com.example.domain.ShopItem
import com.example.domain.ShopListRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ShopListRepositoryImpl(private val dao: ShopDao) : ShopListRepository {

    private val mapper = ShopListMapper()

    override fun addShopItem(shopItem: ShopItem) {
        dao.insertShopItem(mapper.mapEntityToDBModel(shopItem = shopItem))
    }

    override fun deleteShopItem(shopItem: ShopItem) {
        dao.deleteShopItem(mapper.mapEntityToDBModel(shopItem = shopItem))
    }

    override fun getShopList(): Flow<List<ShopItem>> {
        return dao.getShopList().map { mapper.mapListDbModelToListEntity(list = it) }
    }

//    override fun getShopList(): Flow<List<ShopItem>> = Transformations.map(
//        dao.getShopList()
//    ) {
//        mapper.mapListDbModelToListEntity(it)
//    }

    override fun editShopList(shopItem: ShopItem) {
    }

    override fun getShopItem(shopItemId: Int): ShopItem {
        val dbModel = dao.getShopItem(shopItemId = shopItemId)
        return mapper.mapDbModelToEntity(dbModel)
    }
}