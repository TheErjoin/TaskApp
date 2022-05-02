package com.example.taskappkotlin.presentation.fragment.add.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.ShopItem
import com.example.domain.ShopListRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class AddViewModel @Inject constructor(private val repository: ShopListRepository) : ViewModel() {

    fun addShopItem(shopItem: ShopItem) {
        viewModelScope.launch {
            repository.addShopItem(shopItem)
        }
    }

}