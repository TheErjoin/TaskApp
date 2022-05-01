package com.example.taskappkotlin.presentation.add.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.domain.ShopListRepository

class AddViewModelFactory(val repository: ShopListRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AddViewModel(repository = repository) as T
    }
}