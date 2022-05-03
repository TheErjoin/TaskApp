package com.example.taskappkotlin.presentation.fragment.add.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.domain.AddShopItemUseCase
import javax.inject.Inject

class AddViewModelFactory @Inject constructor(val addShopItemUseCase: AddShopItemUseCase) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AddViewModel(addShopItemUseCase = addShopItemUseCase) as T
    }
}