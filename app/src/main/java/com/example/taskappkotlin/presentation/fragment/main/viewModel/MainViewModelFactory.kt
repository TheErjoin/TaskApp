package com.example.taskappkotlin.presentation.fragment.main.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.domain.AddShopItemUseCase
import com.example.domain.DeleteShopItemUseCase
import com.example.domain.GetShopListUseCase
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(
    val getShopListUseCase: GetShopListUseCase,
    val deleteShopItemUseCase: DeleteShopItemUseCase,
    val addShopItemUseCase: AddShopItemUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(
            getShopListUseCase = getShopListUseCase,
            deleteShopItemUseCase = deleteShopItemUseCase,
            addShopItemUseCase = addShopItemUseCase
        ) as T
    }
}