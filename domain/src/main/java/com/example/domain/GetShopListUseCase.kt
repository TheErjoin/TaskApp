package com.example.domain

import javax.inject.Inject

class GetShopListUseCase @Inject
constructor(val shopListRepository: ShopListRepository) {

    fun getShopList() = shopListRepository.getShopList()

}