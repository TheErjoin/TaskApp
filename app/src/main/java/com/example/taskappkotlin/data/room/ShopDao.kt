package com.example.taskappkotlin.data.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ShopDao {

    @Query("SELECT * FROM shop_items")
    fun getShopList(): LiveData<List<ShopItemDBModel>>

    @Query("SELECT * FROM shop_items WHERE id =:shopItemId LIMIT 1")
    fun getShopItem(shopItemId: Int): ShopItemDBModel

    @Insert
    fun addShopItem(shopItemDBModel: ShopItemDBModel)

    @Delete
    fun deleteShopItem(shopItemDBModel: ShopItemDBModel)

    @Update
    fun updateShopItem(shopItemDBModel: ShopItemDBModel)
}