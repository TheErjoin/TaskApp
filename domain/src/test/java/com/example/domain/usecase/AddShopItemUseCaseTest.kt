package com.example.domain.usecase

import com.example.domain.entity.ShopItem
import com.example.domain.repository.ShopListRepository
import org.junit.Test
import org.mockito.Mockito
import org.mockito.kotlin.mock

class AddShopItemUseCaseTest {

    val shopListRepository = mock<ShopListRepository>()

    @Test
    fun `should add item in shopItem`() {

        val testList = ShopItem("erjan", 12, true, 12)
        Mockito.`when`(shopListRepository.addShopItem(testList))


    }

}