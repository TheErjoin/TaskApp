package com.example.taskappkotlin.presentation.fragment.add.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.AddShopItemUseCase
import com.example.domain.ShopItem
import kotlinx.coroutines.launch
import javax.inject.Inject

class AddViewModel @Inject constructor(val addShopItemUseCase: AddShopItemUseCase) :
    ViewModel() {

    fun addShopItem(shopItem: ShopItem) {
        viewModelScope.launch {
            addShopItemUseCase.addShopItem(shopItem)
        }
    }

}