package com.example.taskappkotlin.presentation.fragment.main.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.AddShopItemUseCase
import com.example.domain.DeleteShopItemUseCase
import com.example.domain.GetShopListUseCase
import com.example.domain.ShopItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    val getShopListUseCase: GetShopListUseCase,
    val deleteShopItemUseCase: DeleteShopItemUseCase,
    val addShopItemUseCase: AddShopItemUseCase
) :
    ViewModel() {

    private val _getShopList = MutableStateFlow<List<ShopItem>>(mutableListOf())
    val getShopList = _getShopList.asStateFlow()

    init {
        getList()
    }

    fun getList() {
        viewModelScope.launch {
            getShopListUseCase.getShopList().collect {
                _getShopList.value = it
            }
        }
    }

    fun deleteShopItem(shopItem: ShopItem) {
        viewModelScope.launch {
            deleteShopItemUseCase.deleteShopItem(shopItem)
        }
    }

    fun addShopItem(shopItem: ShopItem) {
        viewModelScope.launch {
            addShopItemUseCase.addShopItem(shopItem)
        }
    }

}