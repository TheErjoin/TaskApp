package com.example.taskappkotlin.presentation.fragment.main.viewModel

import app.cash.turbine.test
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.mockito.kotlin.mock

class MainViewModelTest {

    var viewModel = mock<MainViewModel>()

    @Test
    fun `should get data with shopItem`() = runBlocking {
        viewModel.getShopList.test {

        }
    }
}