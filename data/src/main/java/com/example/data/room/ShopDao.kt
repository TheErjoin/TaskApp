package com.example.data.room

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ShopDao {

    @Query("SELECT * FROM shop_items ORDER BY count ASC")
    fun getShopList(): Flow<List<ShopItemDBModel>>

    @Query("SELECT * FROM shop_items WHERE id =:shopItemId LIMIT 1")
    fun getShopItem(shopItemId: Int): ShopItemDBModel

    @Insert
    fun insertShopItem(shopItemDBModel: ShopItemDBModel)

    @Delete
    fun deleteShopItem(shopItemDBModel: ShopItemDBModel)

    @Update
    fun updateShopItem(shopItemDBModel: ShopItemDBModel)
}