package com.example.domain

class GetShopListUseCase(private val shopListRepository: ShopListRepository) {

    fun getShopList() = shopListRepository.getShopList()

}