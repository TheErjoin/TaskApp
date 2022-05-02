package com.example.taskappkotlin.presentation.fragment.main.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.ShopItem
import com.example.domain.ShopListRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(private val repository: ShopListRepository) : ViewModel() {

    private val _getShopList = MutableStateFlow<List<ShopItem>>(mutableListOf())
    val getShopList = _getShopList.asStateFlow()

    init {
        getList()
    }

    fun getList() {
        viewModelScope.launch {
            repository.getShopList().collect {
                _getShopList.value = it
            }
        }
    }

    fun deleteShopItem(shopItem: ShopItem) {
        viewModelScope.launch {
            repository.deleteShopItem(shopItem)
        }
    }

}