package com.example.domain.usecase

import com.example.domain.repository.ShopListRepository
import javax.inject.Inject

class GetShopListUseCase @Inject
constructor(val shopListRepository: ShopListRepository) {

    fun getShopList() = shopListRepository.getShopList()

}