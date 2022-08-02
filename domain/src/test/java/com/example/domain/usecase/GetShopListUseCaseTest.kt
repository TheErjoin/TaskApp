package com.example.domain.usecase

import com.example.domain.entity.ShopItem
import com.example.domain.repository.ShopListRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.mock

class GetShopListUseCaseTest {

    val shopListRepository = mock<ShopListRepository>()

    @Test
    fun `should get list shop item`(){

    }

}