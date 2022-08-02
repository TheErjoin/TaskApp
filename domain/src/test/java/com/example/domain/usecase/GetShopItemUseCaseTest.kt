package com.example.domain.usecase

import com.example.domain.entity.ShopItem
import com.example.domain.repository.ShopListRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.mock

class GetShopItemUseCaseTest {

    val shopListRepository = mock<ShopListRepository>()

    @Test
    fun test1() {

        val testList = ShopItem("erjan", 12, true, 12)
        Mockito.`when`(shopListRepository.getShopItem(12)).thenReturn(testList)

        val useCase = GetShopItemUseCase(repository = shopListRepository)
        val actual = useCase.getShopItem(12)
        val expected = ShopItem("erjan", 12, true, 12)
        Assertions.assertEquals(expected, actual)
    }

}